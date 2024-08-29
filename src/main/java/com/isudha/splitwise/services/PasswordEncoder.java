package com.isudha.splitwise.services;

public interface PasswordEncoder {

    public String encode(String plainText);

    boolean matches(String plainText, String hashedText);
}
