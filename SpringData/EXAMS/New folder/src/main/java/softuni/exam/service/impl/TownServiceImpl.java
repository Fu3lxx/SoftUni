package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.town.TownSeedDto;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validator;
    public static final String FILE_PATH =  "src/main/resources/files/json/towns.json";

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validator = validationUtil;
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
                townRepository.save(modelMapper.map(townSeedDto,Town.class));
                output.append(String.format("Successfully imported %s - %d",
                        townSeedDto.getName(),townSeedDto.getPopulation()));
            }else {
                output.append("Invalid Town");
            }
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    @Override
    public Town findTownByName(String name) {
        return townRepository.findByName(name);
    }
}
