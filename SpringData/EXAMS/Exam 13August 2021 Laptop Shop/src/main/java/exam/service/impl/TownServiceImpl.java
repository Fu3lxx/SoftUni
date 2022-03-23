package exam.service.impl;

import exam.model.dto.town.TownSeedDto;
import exam.model.dto.town.TownSeedRootDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    public static final String FILE_PATH = "src/main/resources/files/xml/towns.xml";

    public TownServiceImpl(TownRepository townRepository, XmlParser xmlParser, ValidationUtil validator,
                           ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {
        StringBuilder output = new StringBuilder();
        TownSeedRootDto rootDto = xmlParser.fromFile(FILE_PATH,TownSeedRootDto.class);

        for (TownSeedDto townDto:rootDto.getTowns()){
            boolean isValid = validator.isValid(townDto);

            if (isValid){
                Town town = modelMapper.map(townDto,Town.class);
                townRepository.save(town);
                output.append(String.format("Successfully imported %s",town.getName()));
            }else {
                output.append("Invalid town");
            }
            output.append(System.lineSeparator());
        }

        return output.toString();
    }

    @Override
    public Town getTownByName(String name) {
        return townRepository.findByName(name);
    }
}
