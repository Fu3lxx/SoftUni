package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.TownSeedDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {
    
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    private final TownRepository townRepository;
    public static final String FILE_PATH = "src/main/resources/files/json/towns.json";

    public TownServiceImpl(Gson gson, ModelMapper modelMapper, ValidationUtil validator, TownRepository townRepository) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.townRepository = townRepository;
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
    public String importTowns() throws IOException {
        StringBuilder output = new StringBuilder();
        TownSeedDto[] townSeedDtos = gson.fromJson(readTownsFileContent(),TownSeedDto[].class);

        for (TownSeedDto townSeedDto : townSeedDtos) {
            boolean isValid = validator.isValid(townSeedDto);

            if (isValid){
                Town town = modelMapper.map(townSeedDto,Town.class);
                townRepository.save(town);
                output.append(String.format("Successfully imported town %s - %d",town.getTownName(),town.getPopulation()));
            }else {
                output.append("Invalid town");
            }
            output.append(System.lineSeparator());
        }
        
        return output.toString();
    }

    @Override
    public Town findTownByName(String name) {
        return townRepository.findByTownName(name);
    }
}
