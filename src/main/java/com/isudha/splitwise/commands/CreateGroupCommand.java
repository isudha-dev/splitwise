package com.isudha.splitwise.commands;

import com.isudha.splitwise.controllers.GroupController;
import com.isudha.splitwise.dtos.CreateGroupDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CreateGroupCommand implements Command{

    private GroupController groupController;


    @Override
    public boolean matches(String input) {
        String[] tokens = getTokens(input);
        if(tokens[0].equals(Commands.CREATE_GROUP_COMMAND)){
            return true;
        }
        return false;
    }

    // create-group name createdBy(num) mem1,mem2,mem3 adm1,adm2,adm3
    @Override
    public void execute(String input) {
        String[] tokens = getTokens(input);
        List<Long> memberIds = Arrays.stream(tokens[3].split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());

        List<Long> adminIds = Arrays.stream(tokens[4].split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());

        CreateGroupDto request = CreateGroupDto.builder()
                .name(tokens[1])
                .createdBy(Long.valueOf(tokens[2]))
                .memberIds(memberIds)
                .adminIds(adminIds)
                .build();

        groupController.createGroup(request);
    }
}
