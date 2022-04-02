package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.AgentSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class AgentServiceImpl implements AgentService {

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final AgentRepository agentRepository;
    private final ValidationUtil validator;
    private final TownService townService;
    private static final String FILE_PATH = "src/main/resources/files/json/agents.json";

    public AgentServiceImpl(Gson gson, ModelMapper modelMapper, AgentRepository agentRepository,
                            ValidationUtil validator, TownService townService) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.agentRepository = agentRepository;
        this.validator = validator;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder output = new StringBuilder();
        AgentSeedDto[] agentSeedDtos = gson.fromJson(readAgentsFromFile(),AgentSeedDto[].class);

        for (AgentSeedDto agentSeedDto : agentSeedDtos) {
            boolean isValid = validator.isValid(agentSeedDto);

            if (isValid && findAgentByFirstName(agentSeedDto.getFirstName()) == null){
                Agent agent = modelMapper.map(agentSeedDto,Agent.class);
                Town town = townService.findTownByName(agentSeedDto.getTown());
                agent.setTown(town);
                agentRepository.save(agent);
                output.append(String.format("Successfully imported agent - %s %s",agent.getFirstName(),agent.getLastName()));
            }else {
                output.append("Invalid agent");
            }
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    @Override
    public Agent findAgentByFirstName(String name) {
        return agentRepository.findByFirstName(name);
    }
}
