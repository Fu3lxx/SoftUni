package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.entity.Picture;
import softuni.exam.models.entity.dto.picture.PictureSeedDto;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@Service
public class PictureServiceImpl implements PictureService {

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final PictureRepository pictureRepository;
    private final ValidationUtil validator;
    private final CarService carService;
    private static final String PICTURES_PATH = "src/main/resources/files/json/pictures.json";

    public PictureServiceImpl(Gson gson, ModelMapper modelMapper, PictureRepository pictureRepository, ValidationUtil validator, CarService carService) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureRepository;
        this.validator = validator;
        this.carService = carService;
    }


    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }



    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURES_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder picturesOutput = new StringBuilder();

        PictureSeedDto[] pictureSeedDtos = gson.fromJson(readPicturesFromFile(),PictureSeedDto[].class);
        System.out.println("s");

        for (PictureSeedDto pictureSeedDto : pictureSeedDtos) {
            boolean isValid = validator.isValid(pictureSeedDto);

            if (isValid){
                picturesOutput.append(String.format("Successfully import picture - %s",pictureSeedDto.getName()));
                Picture picture = modelMapper.map(pictureSeedDto,Picture.class);
                picture.setCar(carService.findById(pictureSeedDto.getCar()));
                pictureRepository.save(picture);
            }else {
                picturesOutput.append("Invalid picture");
            }
            picturesOutput.append(System.lineSeparator());
        }

        return picturesOutput.toString();
    }

    @Override
    public Set<Picture> findAllByCarId(Long id) {
        return pictureRepository.findAllByCar_Id(id);
    }


}
