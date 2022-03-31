package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.domain.entities.dtos.xml.teams.TeamSeedDto;
import softuni.exam.domain.entities.dtos.xml.teams.TeamSeedRootDto;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.FileUtilImpl;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class TeamServiceImpl implements TeamService {

    private final ModelMapper modelMapper;
    private final ValidatorUtil validator;
    private final FileUtilImpl fileUtil;
    private final TeamRepository teamRepository;
    private final XmlParser xmlParser;
    private final PictureService pictureService;
    public static final String FILE_PATH = "src/main/resources/files/xml/teams.xml";

    public TeamServiceImpl(ModelMapper modelMapper, ValidatorUtil validator, FileUtilImpl fileUtil,
                           TeamRepository teamRepository, XmlParser xmlParser, PictureService pictureService) {
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.fileUtil = fileUtil;
        this.teamRepository = teamRepository;
        this.xmlParser = xmlParser;
        this.pictureService = pictureService;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder output = new StringBuilder();
        TeamSeedRootDto teamSeedRootDto = xmlParser.fromFile(FILE_PATH,TeamSeedRootDto.class);

        for (TeamSeedDto teamSeedDto: teamSeedRootDto.getTeams()){
            boolean isValid = validator.isValid(teamSeedDto);
            Picture picture = pictureService.findByPictureUrl(teamSeedDto.getPicture().getUrl());
            if (isValid && picture != null){
                Team team = modelMapper.map(teamSeedDto,Team.class);
                team.setPicture(picture);
                teamRepository.save(team);
                output.append(String.format("Successfully imported - %s",team.getName()));
            }else {
                output.append("Invalid team");
            }
            output.append(System.lineSeparator());
        }

        return output.toString();
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return fileUtil.readFile(FILE_PATH);
    }

    @Override
    public Team findTeamByName(String name) {
        return teamRepository.findByName(name);
    }
}
