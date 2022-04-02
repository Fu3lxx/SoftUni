package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.apartment.ApartmentRootSeedDto;
import softuni.exam.models.dto.xml.apartment.ApartmentSeedDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    private final ApartmentRepository apartmentRepository;
    private final TownService townService;
    public static final String FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    public ApartmentServiceImpl(XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validator,
                                ApartmentRepository apartmentRepository, TownService townService) {
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.apartmentRepository = apartmentRepository;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder output = new StringBuilder();
        ApartmentRootSeedDto apartmentRootSeedDto = xmlParser.fromFile(FILE_PATH,ApartmentRootSeedDto.class);

        for (ApartmentSeedDto apartmentSeedDto: apartmentRootSeedDto.getApartment()){
            boolean isValid = validator.isValid(apartmentSeedDto);
            Apartment check = findByTown_TownNameAndArea(apartmentSeedDto.getTown(),apartmentSeedDto.getArea());

            if (isValid && check == null){
                Apartment apartment = modelMapper.map(apartmentSeedDto,Apartment.class);
                Town town = townService.findTownByName(apartmentSeedDto.getTown());
                apartment.setTown(town);
                apartmentRepository.save(apartment);
                output.append(String.format("Successfully imported apartment %s - %.2f",apartment.getApartmentType(),apartment.getArea()));
            }else {
                output.append("Invalid apartment");
            }
            output.append(System.lineSeparator());


        }

        return output.toString();
    }

    @Override
    public Apartment findByTown_TownNameAndArea(String town, BigDecimal area) {
        return apartmentRepository.findByTown_TownNameAndArea(town,area);
    }

    @Override
    public Apartment findApartmentById(Long id) {
        return apartmentRepository.findById(id).orElse(null);
    }


}
