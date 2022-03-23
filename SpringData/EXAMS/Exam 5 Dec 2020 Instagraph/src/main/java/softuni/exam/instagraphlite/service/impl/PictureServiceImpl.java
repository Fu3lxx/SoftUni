package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.pictures.PictureSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    public static final String PICTURE_PATH = "src/main/resources/files/pictures.json";

    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson,
                              ModelMapper modelMapper, ValidationUtil validator) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }


    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        PictureSeedDto[] pictureDtos = gson.fromJson(readFromFileContent(),PictureSeedDto[].class);
        StringBuilder output = new StringBuilder();

        for (PictureSeedDto pictureDto : pictureDtos) {
            boolean isValid = validator.isValid(pictureDto);

            if (isValid){
                Picture picture = modelMapper.map(pictureDto,Picture.class);
                pictureRepository.save(picture);
                output.append(String.format("Successfully imported Picture, with size %.2f%n",pictureDto.getSize()));
            }else {
                output.append(String.format("Invalid Picture%n"));
            }
        }
        return output.toString();
    }

    @Override
    public String exportPictures() {
        StringBuilder output = new StringBuilder();

        findAllPictureWithSizeBiggerThan(30000)
                .forEach(picture -> {
                    output.append(String.format("%.2f - %s%n",picture.getSize(),picture.getPath()));
                });

        return output.toString();
    }

    @Override
    public Picture findPictureByPath(String path) {
        Picture picture = pictureRepository.findByPath(path);
        if (picture != null){
            return picture;
        }
        return null;
    }

    @Override
    public List<Picture> findAllPictureWithSizeBiggerThan(double size) {
        return pictureRepository.findBySizeIsGreaterThanOrderBySizeAsc(size);
    }
}
