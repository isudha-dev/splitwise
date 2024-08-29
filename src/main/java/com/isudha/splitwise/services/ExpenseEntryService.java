package com.isudha.splitwise.services;

import com.isudha.splitwise.models.Expense;
import com.isudha.splitwise.models.ExpenseEntry;
import com.isudha.splitwise.repositories.ExpenseEntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpenseEntryService {
    private ExpenseEntryRepository expenseEntryRepository;

    public ExpenseEntry createExpenseEntry(ExpenseEntry expenseEntry){
        return expenseEntryRepository.save(expenseEntry);
    }
}
