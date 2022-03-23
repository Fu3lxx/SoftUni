package softuni.exam.service;



import softuni.exam.models.entity.Car;

import java.io.IOException;
import java.util.List;
import java.util.Set;


public interface CarService {

    boolean areImported();

    String readCarsFileContent() throws IOException;
	
	String importCars() throws IOException;

    String getCarsOrderByPicturesCountThenByMake();

    Car findById(Long carId);

    String findAllCarsSortByPictureCountAndMake();

}
