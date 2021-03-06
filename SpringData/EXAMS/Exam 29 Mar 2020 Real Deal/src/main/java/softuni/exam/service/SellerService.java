package softuni.exam.service;

import softuni.exam.models.entity.Picture;
import softuni.exam.models.entity.Seller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Set;

public interface SellerService {
    
    boolean areImported();

    String readSellersFromFile() throws IOException;

    String importSellers() throws IOException, JAXBException;

    Seller findSellerById (Long id);



}
