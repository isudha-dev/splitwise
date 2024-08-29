package com.isudha.splitwise.commands;

import java.util.List;

public interface Command {

    public default String[] getTokens(String input){
        return input.split(" ");
    }

    public boolean matches(String input);
    public void execute(String input);
}
