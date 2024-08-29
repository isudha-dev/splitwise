package com.isudha.splitwise.controllers;

import com.isudha.splitwise.dtos.CreateExpenseDto;
import com.isudha.splitwise.models.Expense;
import com.isudha.splitwise.models.ExpenseEntry;
import com.isudha.splitwise.services.ExpenseEntryService;
import com.isudha.splitwise.services.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ExpenseController {
    private ExpenseService expenseService;
    private ExpenseEntryService expenseEntryService;

    public Expense createExpense(CreateExpenseDto request){
        return expenseService.createExpense(request);
    }

    public ExpenseEntry createExpenseEntry(ExpenseEntry expenseEntry){
        return expenseEntryService.createExpenseEntry(expenseEntry);
    }

}
