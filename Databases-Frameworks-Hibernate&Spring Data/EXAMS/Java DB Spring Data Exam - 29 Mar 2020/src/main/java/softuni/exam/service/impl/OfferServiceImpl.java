package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.dto.offer.OfferSeedDto;
import softuni.exam.models.entity.dto.offer.OfferSeedRootDto;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.PictureService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validator;
    private final OfferRepository offerRepository;
    private final CarService carService;
    private final PictureService pictureService;
    private final SellerService sellerService;
    public static final String OFFERS_PATH = "src/main/resources/files/xml/offers.xml";

    public OfferServiceImpl(ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validator
            , OfferRepository offerRepository, CarService carService, PictureService pictureService, SellerService sellerService) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validator = validator;
        this.offerRepository = offerRepository;
        this.carService = carService;
        this.pictureService = pictureService;
        this.sellerService = sellerService;
    }


    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder offerOutput = new StringBuilder();

        OfferSeedRootDto offerSeedRootDto = xmlParser.fromFile(OFFERS_PATH, OfferSeedRootDto.class);

        for (OfferSeedDto offerDto: offerSeedRootDto.getOffers()){
            boolean isValid = validator.isValid(offerDto);

            if (isValid){
                offerOutput.append(String.format("Successfully import offer %s - %b",offerDto.getAddedOn(),offerDto.isHasGoldStatus()));
                Offer offer = modelMapper.map(offerDto,Offer.class);
                offer.setSeller(sellerService.findSellerById(offerDto.getSeller().getId()));
                offer.setCar(carService.findById(offerDto.getCar().getId()));
                offer.setPictures(pictureService.findAllByCarId(offerDto.getCar().getId()));
                offerRepository.save(offer);

            }
            else {
                offerOutput.append("Invalid offer");
            }
            offerOutput.append(System.lineSeparator());

        }

        return offerOutput.toString();
    }
}
