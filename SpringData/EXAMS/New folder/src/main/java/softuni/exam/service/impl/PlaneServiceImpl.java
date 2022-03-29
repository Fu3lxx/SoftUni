package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.plane.PlaneSeedDto;
import softuni.exam.models.dtos.plane.PlaneSeedRootDto;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PlaneServiceImpl implements PlaneService {

    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    public static final String FILE_PATH = "src/main/resources/files/xml/planes.xml";

    public PlaneServiceImpl(PlaneRepository planeRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validator) {
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }


    @Override
    public boolean areImported() {
        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder output = new StringBuilder();
        PlaneSeedRootDto planeSeedRootDto = xmlParser.fromFile(FILE_PATH,PlaneSeedRootDto.class);
        System.out.println();
        for (PlaneSeedDto planeSeedDto:planeSeedRootDto.getPlanes()){
            boolean isValid = validator.isValid(planeSeedDto);

            if (isValid){
                Plane plane = modelMapper.map(planeSeedDto,Plane.class);
                planeRepository.save(plane);
                output.append(String.format("Successfully imported Plane %s",plane.getRegisterNumber()));
            }else {
                output.append("Invalid Plane");
            }
            output.append(System.lineSeparator());
        }

        return output.toString();
    }

    @Override
    public Plane findPlaneByRegNumber(String number) {
        return planeRepository.findByRegisterNumber(number);
    }
}
