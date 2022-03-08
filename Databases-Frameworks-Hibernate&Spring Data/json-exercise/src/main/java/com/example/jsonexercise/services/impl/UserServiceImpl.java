package com.example.jsonexercise.services.impl;

import com.example.jsonexercise.model.dto.UserSeedDto;
import com.example.jsonexercise.model.dto.UserSoldDto;
import com.example.jsonexercise.model.entity.User;
import com.example.jsonexercise.repository.UserRepository;
import com.example.jsonexercise.services.UserService;
import com.example.jsonexercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.jsonexercise.constant.GlobalConstant.*;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private static final String USER_PATH = "users.json";
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.userRepository = userRepository;
    }

    @Override
    public void seedUsers() throws IOException {
        if (userRepository.count() > 0){
            return;
        }
        Arrays.stream(gson.fromJson(
                Files.readString(Path.of(RESOURCES_FILE_PATH + USER_PATH)), UserSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public User getRandomUser() {
        Long randomId = ThreadLocalRandom.current().nextLong(1,userRepository.count() +1);

        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUsersWithMoreThanOneSoldProductOrdered() {
        return userRepository.findAllUsersWithMoreThanOneSoldProductOrdered()
                .stream()
                .map(user -> modelMapper.map(user,UserSoldDto.class))
                .collect(Collectors.toList());
    }
}
