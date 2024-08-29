package com.isudha.splitwise.commands;

import com.isudha.splitwise.controllers.ExpenseController;
import com.isudha.splitwise.exceptions.ResourceNotFound;
import com.isudha.splitwise.models.Expense;
import com.isudha.splitwise.models.ExpenseEntry;
import com.isudha.splitwise.models.User;
import com.isudha.splitwise.models.enums.ExpenseType;
import com.isudha.splitwise.services.ExpenseEntryService;
import com.isudha.splitwise.services.ExpenseService;
import com.isudha.splitwise.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddExpenseCommand implements Command{

    private ExpenseController expenseController;
    private ExpenseService expenseService;
    private UserService userService;

    private ExpenseEntryService expenseEntryService;

    @Override
    public boolean matches(String input) {
        String[] tokens = getTokens(input);
        if(tokens[0].equals(Commands.ADD_EXPENSE_COMMAND))
            return true;
        return false;
    }

    // add-expense expense_id user_id amount PAID/OWED
    @Override
    public void execute(String input) {
        String[] tokens = getTokens(input);
        Expense expense = expenseService.findExpense(Long.valueOf(tokens[1])).orElseThrow(() -> new ResourceNotFound("Expense not found"));
        User user = userService.findUser(Long.valueOf(tokens[2]));

        ExpenseEntry expenseEntry = ExpenseEntry.builder()
                .expense(expense)
                .user(user)
                .amount(Double.valueOf(tokens[3]))
                .type(ExpenseType.valueOf(tokens[4]))
                .build();

        expenseController.createExpenseEntry(expenseEntry);

    }
}
