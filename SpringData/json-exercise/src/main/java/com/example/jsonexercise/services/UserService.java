package com.example.jsonexercise.services;

import com.example.jsonexercise.model.dto.UserSoldDto;
import com.example.jsonexercise.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void seedUsers() throws IOException;
    User getRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThanOneSoldProductOrdered();
}
