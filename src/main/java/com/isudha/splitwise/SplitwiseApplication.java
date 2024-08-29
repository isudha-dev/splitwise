package com.isudha.splitwise;

import com.isudha.splitwise.commands.Command;
import com.isudha.splitwise.commands.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseApplication implements CommandLineRunner {

    private Scanner scanner;
    private CommandExecutor commandExecutor;

    public SplitwiseApplication(CommandExecutor commandExecutor, List<Command> commandList){
        this.scanner = new Scanner(System.in);
        this.commandExecutor = commandExecutor;
        commandExecutor.addCommands(commandList);
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Enter input:");
            String input = scanner.nextLine();
            if(input.equals("exit"))
                break;
            else commandExecutor.execute(input);
        }
    }
}
