package softuni.exam.service;

import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;

public interface ApartmentService {
    
    boolean areImported();

    String readApartmentsFromFile() throws IOException;

    String importApartments() throws IOException, JAXBException;

    Apartment findByTown_TownNameAndArea (String town, BigDecimal area);

    Apartment findApartmentById (Long id);
}
