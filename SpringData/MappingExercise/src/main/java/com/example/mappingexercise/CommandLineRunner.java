package com.example.mappingexercise;

import com.example.mappingexercise.model.dto.GameAddDto;
import com.example.mappingexercise.model.dto.UserLoginDto;
import com.example.mappingexercise.model.dto.UserRegisterDto;
import com.example.mappingexercise.service.GameService;
import com.example.mappingexercise.service.UserService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final Scanner scanner;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {

        while (true){
            System.out.println("Enter your commands");
            String [] commands = scanner.nextLine().split("\\|");

            switch (commands[0]){
                case "RegisterUser" ->{
                    String email = commands[1];
                    String password = commands[2];
                    String confirmPassword = commands[3];
                    String fullName = commands[4];
                    userService.registerUser(new UserRegisterDto(email,password,confirmPassword,fullName));
                    }

                case "LoginUser"-> {
                    String email = commands[1];
                    String password = commands[2];
                    userService.loginUser(new UserLoginDto(email,password));
                }

                case "Logout" -> userService.logout();

                case "AddGame" -> {
                    String title = commands[1];
                    BigDecimal price = BigDecimal.valueOf(Double.parseDouble(commands[2]));
                    Double size = Double.parseDouble(commands[3]);
                    String trailer = commands[4];
                    String thumbnailUrl = commands[5];
                    String description = commands[6];
                    String releaseDate = commands[7];
                    gameService.addGame(new GameAddDto(title,price,size,trailer,thumbnailUrl,description,releaseDate));
                }

                case "EditGame" -> {
                    Long id = Long.parseLong(commands[1]);
                    double price = Double.parseDouble(commands[2].split("=")[1]);
                    double size = Double.parseDouble(commands[3].split("=")[1]);
                    gameService.editGame(id,BigDecimal.valueOf(price),size);

                }

                case "DeleteGame" -> gameService.deleteGame(Long.parseLong(commands[1]));

                case "AllGames" -> gameService.allGames();

                case "DetailGame" -> gameService.detailGame(commands[1]);
            }
        }
    }
}
//Todo
// From exercise 4 OwnedGames command is not implemented