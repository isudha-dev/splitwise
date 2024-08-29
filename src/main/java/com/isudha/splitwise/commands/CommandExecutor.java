package com.isudha.splitwise.commands;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.security.cert.CertPath;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class CommandExecutor {

    private List<Command> commandsList = new ArrayList<>();

    public void addCommand(Command c){
        commandsList.add(c);
    }

    public void removeCommand(Command c){
        commandsList.remove(c);
    }

    public void execute(String input){
        for (Command cm: commandsList) {
            if(cm.matches(input)){
                cm.execute(input);
                break;
            }
        }
    }

    public void addCommands(List<Command> commandList) {
        commandsList.addAll(commandList);
    }

}
