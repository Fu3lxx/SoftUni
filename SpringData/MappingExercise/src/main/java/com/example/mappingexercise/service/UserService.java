package com.example.mappingexercise.service;

import com.example.mappingexercise.model.dto.UserLoginDto;
import com.example.mappingexercise.model.dto.UserRegisterDto;
import com.example.mappingexercise.model.entiry.User;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    boolean isLoggedUserAdmin ();

    User getLoggedUser();


}
