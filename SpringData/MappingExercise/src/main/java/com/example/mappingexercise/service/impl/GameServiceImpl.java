package com.example.mappingexercise.service.impl;

import com.example.mappingexercise.model.dto.GameAddDto;
import com.example.mappingexercise.model.entiry.Game;
import com.example.mappingexercise.model.entiry.User;
import com.example.mappingexercise.repository.GameRepository;
import com.example.mappingexercise.service.GameService;
import com.example.mappingexercise.service.UserService;
import com.example.mappingexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.getViolations(gameAddDto);


        if (!violations.isEmpty()){
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }
        if (userService.getLoggedUser() != null){
            if (userService.isLoggedUserAdmin()){
                Game game = modelMapper.map(gameAddDto,Game.class);
                game.setReleaseDate(LocalDate.parse(gameAddDto.getReleaseDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                gameRepository.save(game);
                System.out.println("Added game " + gameAddDto.getTitle());
            }else {
                System.out.println("Only admin can add games");
            }
        }else {
            System.out.println("Please log user");
        }
    }

    @Override
    public void editGame(Long gameId, BigDecimal price, Double size) {
        if (userService.getLoggedUser() != null){
            if (userService.isLoggedUserAdmin()){
                Game game = gameRepository.findById(gameId).orElse(null);
                if (game == null){
                    System.out.println("There is no such game");
                    return;
                }
                game.setPrice(price);
                game.setSize(size);
                System.out.printf("Edited %s%n",game.getTitle());

                gameRepository.save(game);
            }else {
                System.out.println("Only admin can edit games");
            }
        }else {
            System.out.println("Please log user");
        }
    }

    @Override
    public void deleteGame(Long id) {
        if (userService.getLoggedUser() != null){
            if (userService.isLoggedUserAdmin()){
                Game game = gameRepository.findById(id).orElse(null);
                if (game != null){
                    gameRepository.deleteById(id);
                    System.out.printf("Deleted %s%n",game.getTitle());
                }else {
                    System.out.println("Game with that id doesn't exist.");
                }
            }
        }else {
            System.out.println("Please log user");
        }
    }

    @Override
    public void allGames() {
        List<Game> games = gameRepository.findAll();
        for (Game game : games) {
            System.out.printf("%s %.2f%n",game.getTitle(),game.getPrice());
        }
    }

    @Override
    public void detailGame(String title) {
        Game game = gameRepository.findByTitle(title);
        if (game != null){
            System.out.printf("Title: %s%n",game.getTitle());
            System.out.println();
            System.out.printf("Price: %.2f%n",game.getPrice());
            System.out.println();
            System.out.printf("Description: %s%n",game.getDescription());
            System.out.println();
            System.out.printf("Release date: %s%n",game.getReleaseDate().toString());
        }else {
            System.out.printf("There is no such game %s%n",title);
        }
    }
}
