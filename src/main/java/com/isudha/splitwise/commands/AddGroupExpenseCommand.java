package com.isudha.splitwise.commands;

import com.isudha.splitwise.controllers.GroupController;
import com.isudha.splitwise.dtos.CreateGroupExpenseDto;
import com.isudha.splitwise.models.Group;
import com.isudha.splitwise.models.GroupExpense;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AddGroupExpenseCommand implements Command{

    private GroupController groupController;

    @Override
    public boolean matches(String input) {
        String[] tokens = getTokens(input);
        if(tokens[0].equals(Commands.ADD_GROUP_EXPENSE_COMMAND))
            return true;
        return false;
    }

    // add-group-expense groupId desc amount createBy users
    @Override
    public void execute(String input) {
        String[] tokens = getTokens(input);
        List<Long> users = Arrays.stream(tokens[5].split(",")).map(Long::valueOf).collect(Collectors.toList());

        CreateGroupExpenseDto request = CreateGroupExpenseDto.builder()
                .groupId(Long.valueOf(tokens[1]))
                .expenseDescription(tokens[2])
                .expenseAmount(Double.valueOf(tokens[3]))
                .expenseCreatedBy(Long.valueOf(tokens[4]))
                .expenseUsers(users)
                .build();

        groupController.createGroupExpense(request);

    }
}
