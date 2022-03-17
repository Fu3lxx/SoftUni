package softuni.exam.service;


import softuni.exam.models.entity.Picture;

import java.io.IOException;
import java.util.Set;

public interface PictureService {

    boolean areImported();

    String readPicturesFromFile() throws IOException;
	
	String importPictures() throws IOException;

    Set<Picture> findAllByCarId (Long id);


}
