package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.offer.OfferSeedDto;
import softuni.exam.models.dto.xml.offer.OfferSeedRootDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.enums.ApartmentType;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    private final OfferRepository offerRepository;
    private final AgentService agentService;
    private final ApartmentService apartmentService;
    public static final String FILE_PATH = "src/main/resources/files/xml/offers.xml";

    public OfferServiceImpl(XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validator, OfferRepository offerRepository,
                            AgentService agentService, ApartmentService apartmentService) {
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.offerRepository = offerRepository;
        this.agentService = agentService;
        this.apartmentService = apartmentService;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder output = new StringBuilder();
        OfferSeedRootDto offerSeedRootDto = xmlParser.fromFile(FILE_PATH,OfferSeedRootDto.class);

        for (OfferSeedDto offerSeedDto: offerSeedRootDto.getOffers()){
            boolean isValid = validator.isValid(offerSeedDto);
            Agent agent = agentService.findAgentByFirstName(offerSeedDto.getAgent().getName());

            if (isValid && agent != null){
                Offer offer = modelMapper.map(offerSeedDto,Offer.class);
                offer.setAgent(agent);
                offer.setApartment(apartmentService.findApartmentById(offerSeedDto.getApartment().getId()));
                offerRepository.save(offer);
                output.append(String.format("Successfully imported offer %.2f",offer.getPrice()));
            }else {
                output.append("Invalid offer");
            }
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    @Override
    public String exportOffers() {
        StringBuilder output = new StringBuilder();
        ApartmentType three_rooms = ApartmentType.three_rooms;
        List<Offer> bestOffers = offerRepository.findAllByApartmentTypeOrdered(three_rooms);

        for (Offer bestOffer : bestOffers) {
            output.append(String.format("Agent %s %s with offer №:%d%n",
                    bestOffer.getAgent().getFirstName(),bestOffer.getAgent().getLastName(),bestOffer.getId()));
            output.append(String.format("-Apartment area: %.2f%n",bestOffer.getApartment().getArea()));
            output.append(String.format("--Town: %s%n",bestOffer.getApartment().getTown().getTownName()));
            output.append(String.format("---Price: %.2f$%n",bestOffer.getPrice()));

        }
        return output.toString();
    }
}
