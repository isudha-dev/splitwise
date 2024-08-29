package com.isudha.splitwise.controllers;

import com.isudha.splitwise.dtos.RegisterUserDto;
import com.isudha.splitwise.models.User;
import com.isudha.splitwise.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;

    public User registerUser(RegisterUserDto request){
        return userService.createUser(request.toUser());
    }

}
