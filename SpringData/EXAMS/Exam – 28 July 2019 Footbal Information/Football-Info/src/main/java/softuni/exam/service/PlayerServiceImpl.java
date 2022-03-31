package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.domain.entities.dtos.json.PlayerSeedDto;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validator;
    private final TeamService teamService;
    private final PictureService pictureService;
    private final FileUtil fileUtil;
    private static final String FILE_PATH = "src/main/resources/files/json/players.json";

    public PlayerServiceImpl(PlayerRepository playerRepository, Gson gson, ModelMapper modelMapper, ValidatorUtil validator,
                             TeamService teamService, PictureService pictureService, FileUtil fileUtil) {
        this.playerRepository = playerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.teamService = teamService;
        this.pictureService = pictureService;
        this.fileUtil = fileUtil;
    }

    @Override
    public String importPlayers() throws IOException {
        StringBuilder output = new StringBuilder();

        PlayerSeedDto[] playerSeedDtos = gson.fromJson(readPlayersJsonFile(),PlayerSeedDto[].class);
        System.out.println();
        for (PlayerSeedDto playerSeedDto : playerSeedDtos) {
            boolean isValid = validator.isValid(playerSeedDto);

            if (isValid){
                Player player = modelMapper.map(playerSeedDto,Player.class);
                Team team = teamService.findTeamByName(playerSeedDto.getTeam().getName());
                Picture picture = pictureService.findByPictureUrl(playerSeedDto.getPicture().getUrl());
                player.setTeam(team);
                player.setPicture(picture);
                playerRepository.save(player);
                output.append(String.format("Successfully imported player: %s %s",player.getFirstName(),player.getLastName()));
            }else {
                output.append("Invalid player");
            }
            output.append(System.lineSeparator());
        }

        return output.toString();
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return fileUtil.readFile(FILE_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        List<Player> players = playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000L));
        StringBuilder output = new StringBuilder();
        for (Player player : players) {
            output.append(String.format("Player name: %s %s%n",player.getFirstName(),player.getLastName()));
            output.append(String.format("\tNumber: %d%n",player.getNumber()));
            output.append(String.format("\tSalary: %.2f%n",player.getSalary()));
            output.append(String.format("\tTeam: %s%n",player.getTeam().getName()));
        }
        return output.toString();
    }

    @Override
    public String exportPlayersInATeam() {
        String teamName = "North Hub";
        List<Player> players = playerRepository.findAllByTeam(teamService.findTeamByName(teamName));
        StringBuilder output =new StringBuilder();

        output.append(String.format("Team: %s%n",teamName));
        for (Player player : players) {
            output.append(String.format("\tPlayer name: %s %s - %s%n",player.getFirstName(),player.getLastName(),player.getPosition()));
            output.append(String.format("\tNumber: %d%n",player.getNumber()));
        }

        return output.toString();
    }
}
