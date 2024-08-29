package com.isudha.splitwise.commands;

import com.isudha.splitwise.controllers.ExpenseController;
import com.isudha.splitwise.dtos.CreateExpenseDto;
import com.isudha.splitwise.models.Expense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CreateExpenseCommand implements Command {

    private ExpenseController expenseController;
    @Override
    public boolean matches(String input) {
        String tokens[] = getTokens(input);
        if(tokens[0].equals(Commands.CREATE_EXPENSE_COMMAND)){
            return true;
        }
        return false;
    }

    // create-expense name amount createdBy usersList
    @Override
    public void execute(String input) {
        String tokens[] = getTokens(input);
        List<Long> users = Arrays.stream(tokens[4].split(",")).map(Long::valueOf).collect(Collectors.toList());

        CreateExpenseDto createExpenseDto = CreateExpenseDto.builder()
                .name(tokens[1])
                .amount(Double.valueOf(tokens[2]))
                .createdBy(Long.valueOf(tokens[3]))
                .users(users)
                .build();

        expenseController.createExpense(createExpenseDto);
    }
}
