package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.dto.car.CarSeedDto;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;


@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private static final String CARS_FILE_PATH = "src/main/resources/files/json/cars.json";

    public CarServiceImpl(CarRepository carRepository, Gson gson, ValidationUtil validator, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        CarSeedDto[] carSeedDtos = gson.fromJson(readCarsFileContent(),CarSeedDto[].class);
        StringBuilder importCarsOutput = new StringBuilder();

        for (CarSeedDto carSeedDto : carSeedDtos) {
            boolean isValid = validator.isValid(carSeedDto);
            if (isValid){
                importCarsOutput.append(String.format("Successfully imported car - %s - %s",
                        carSeedDto.getMake(),carSeedDto.getModel()));
                carRepository.save(modelMapper.map(carSeedDto,Car.class));
            }else {
                importCarsOutput.append("Invalid car");
            }
            importCarsOutput.append(System.lineSeparator());
        }

        return importCarsOutput.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        return findAllCarsSortByPictureCountAndMake();
    }

    @Override
    public Car findById(Long carId) {
        return carRepository.findById(carId).orElse(null);
    }

    @Override
    public String findAllCarsSortByPictureCountAndMake() {
        StringBuilder stringBuilder = new StringBuilder();
        carRepository.findAllCarsSortByPictureCountAndMake()
                .forEach(car -> {
                    stringBuilder.append(String.format("Car make - %s, model - %s%n",car.getMake(),car.getModel()));
                    stringBuilder.append(String.format("\tKilometers - %d%n",car.getKilometers()));
                    stringBuilder.append(String.format("\tRegistered on - %s%n",car.getRegisteredOn()));
                    stringBuilder.append(String.format("\tNumber of pictures %d",car.getPictures().size()));
                    stringBuilder.append(System.lineSeparator());

                });


        return stringBuilder.toString();
    }

}
