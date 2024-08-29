package com.isudha.splitwise.dtos;

import com.isudha.splitwise.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class RegisterUserDto {
    private String name;
    private String password;
    private String email;
    private String phoneNumber;

    public User toUser() {
        return new User().builder()
                .name(name)
                .password(password)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
