package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.post.PostRootSeedDto;
import softuni.exam.instagraphlite.models.dto.post.PostSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final PictureService pictureService;
    private final ValidationUtil validator;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    public static final String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";

    public PostServiceImpl(PostRepository postRepository, UserService userService,
                           PictureService pictureService, ValidationUtil validator, XmlParser xmlParser, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.pictureService = pictureService;
        this.validator = validator;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder output = new StringBuilder();
        PostRootSeedDto postRootSeedDtos = xmlParser.fromFile(POSTS_FILE_PATH,PostRootSeedDto.class);

        for (PostSeedDto postSeedDto: postRootSeedDtos.getPostSeedDtos()){
            boolean isValid = validator.isValid(postSeedDto);
            User user = userService.findUserByUsername(postSeedDto.getUser().getUsername());
            Picture picture = pictureService.findPictureByPath(postSeedDto.getPicture().getPath());

            if (isValid && user != null && picture != null){
                Post post = modelMapper.map(postSeedDto,Post.class);
                post.setUser(user);
                post.setPicture(picture);

                postRepository.save(post);
                output.append(String.format("Successfully imported Post, made by %s%n",user.getUsername()));
            }else {
                output.append(String.format("Invalid Post%n"));
            }
        }

        return output.toString();
    }
}
