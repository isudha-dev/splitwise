package com.isudha.splitwise.commands;

import com.isudha.splitwise.controllers.UserController;
import com.isudha.splitwise.dtos.RegisterUserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterUserCommand implements Command {
    private UserController userController;
    @Override
    public boolean matches(String input) {
        String[] commandArgs = getTokens(input);
        if(commandArgs[0].matches(Commands.REGISTER_USER_COMMAND))
            return true;
        return false;
    }

    // register-user name password email phoneNumber
    @Override
    public void execute(String input) {
        String[] commandArgs = getTokens(input);
        RegisterUserDto request = RegisterUserDto.builder()
                .name(commandArgs[1])
                .password(commandArgs[2])
                .email(commandArgs[3])
                .phoneNumber(commandArgs[4])
                .build();

        userController.registerUser(request);
    }
}
