package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.users.UserSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final ValidationUtil validator;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PictureService pictureService;
    private static final String USER_FILE_PATH = "src/main/resources/files/users.json";

    public UserServiceImpl(ValidationUtil validator, Gson gson,
                           ModelMapper modelMapper, UserRepository userRepository, PictureService pictureService) {
        this.validator = validator;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.pictureService = pictureService;
    }


    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder output = new StringBuilder();
        UserSeedDto[] userSeedDtos = gson.fromJson(readFromFileContent(),UserSeedDto[].class);

        for (UserSeedDto userSeedDto : userSeedDtos) {
            boolean isValid = validator.isValid(userSeedDto);
            Picture picture = pictureService.findPictureByPath(userSeedDto.getProfilePicture());

            if (isValid && picture != null){
                User user = modelMapper.map(userSeedDto,User.class);
                user.setProfilePicture(picture);
                userRepository.save(user);
                output.append(String.format("Successfully imported User: %s%n",user.getUsername()));
            }else {
                output.append(String.format("Invalid User%n"));
            }
        }

        return output.toString();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder output = new StringBuilder();
        userRepository.findAllUsersOrderedByCountOfPictures()
                .forEach(user -> {
                    output.append(String.format(
                                    "User: %s%n" +
                                    "Post count: %d%n",user.getUsername(),user.getPosts().size()));
                    user.getPosts().stream().sorted(Comparator.comparingDouble(a -> a.getPicture().getSize()))
                            .forEach(post -> {
                                output.append(String.format("==Post Details:%n" +
                                        "----Caption: %s%n" +
                                        "----Picture Size: %.2f%n",post.getCaption(),post.getPicture().getSize()));
                            });

                });
        return output.toString();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
