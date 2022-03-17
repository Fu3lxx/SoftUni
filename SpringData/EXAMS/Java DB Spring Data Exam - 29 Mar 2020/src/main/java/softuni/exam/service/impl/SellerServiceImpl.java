package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.entity.Seller;
import softuni.exam.models.entity.dto.seller.SellerSeedDto;
import softuni.exam.models.entity.dto.seller.SellerSeedRootDto;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    private final XmlParser xmlParser;
    private static final String SELLER_PATH = "src/main/resources/files/xml/sellers.xml";

    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, ValidationUtil validator, XmlParser xmlParser) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLER_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        SellerSeedRootDto sellerSeedRootDto = xmlParser.fromFile(SELLER_PATH,SellerSeedRootDto.class);
        StringBuilder sellerOutPut = new StringBuilder();

        for (SellerSeedDto sellerDto:sellerSeedRootDto.getSellers()){
            boolean isValid = validator.isValid(sellerDto);

            if (isValid){
                sellerOutPut.append(String.format("Successfully import seller %s - %s",
                        sellerDto.getLastName(),sellerDto.getEmail()));
                sellerRepository.save(modelMapper.map(sellerDto, Seller.class));
            }else {
                sellerOutPut.append("Invalid seller");
            }
            sellerOutPut.append(System.lineSeparator());
        }

        return sellerOutPut.toString();
    }

    @Override
    public Seller findSellerById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }
}
