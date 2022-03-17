package com.example.xmlexercise.service;

import com.example.xmlexercise.models.dto.userDto.UserSeedDto;
import com.example.xmlexercise.models.dto.userDto.UserViewRootDto;
import com.example.xmlexercise.models.entity.User;

import java.util.List;

public interface UserService {

    Long getCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UserViewRootDto findUserWithMoreThanOneSoldProducts();
}
