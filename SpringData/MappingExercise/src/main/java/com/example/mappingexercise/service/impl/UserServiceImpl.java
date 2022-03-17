package com.example.mappingexercise.service.impl;

import com.example.mappingexercise.model.dto.UserLoginDto;
import com.example.mappingexercise.model.dto.UserRegisterDto;
import com.example.mappingexercise.model.entiry.User;
import com.example.mappingexercise.repository.UserRepository;
import com.example.mappingexercise.service.UserService;
import com.example.mappingexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser = null;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            System.out.println("Wrong confirm password");
            return;
        }
        Set<ConstraintViolation<UserRegisterDto>> violations =
                validationUtil.getViolations(userRegisterDto);

        if (!violations.isEmpty()){
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }

        User user = modelMapper.map(userRegisterDto,User.class);
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            System.out.println("This email has already taken.");
            return;
        }
        System.out.printf("%s was registered%n",user.getFullName());

        if (userRepository.count() == 0){
            user.setAdmin(true);
        }
        userRepository.save(user);
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<UserLoginDto>> violations = validationUtil.getViolations(userLoginDto);

        User user =userRepository.findByEmailAndPassword(userLoginDto.getEmail(),userLoginDto.getPassword())
                .orElse(null);

        if (user == null){
            System.out.println("Incorrect username or password");
            return;
        }

        if (loggedInUser != null){
            System.out.println("User already logged in");
            return;
        }
        System.out.printf("Successfully logged in %s%n",user.getFullName());
        loggedInUser = user;
    }

    @Override
    public void logout() {
        if (loggedInUser == null){
            System.out.println("Cannot log out. No user was logged in.");
        }else {
            loggedInUser = null;
            System.out.println("User successfully logged out");
        }
    }

    @Override
    public boolean isLoggedUserAdmin() {
        return loggedInUser.isAdmin();
    }

    @Override
    public User getLoggedUser() {
        return loggedInUser;
    }
}
