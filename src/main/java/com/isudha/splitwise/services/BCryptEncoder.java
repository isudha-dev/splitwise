package com.isudha.splitwise.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptEncoder implements PasswordEncoder {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public String encode(String plainText) {
        return bCryptPasswordEncoder.encode(plainText);
    }

    @Override
    public boolean matches(String plainText, String hashedText) {
        return bCryptPasswordEncoder.matches(plainText, hashedText);
    }
}
