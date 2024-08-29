package com.isudha.splitwise.services;

import com.isudha.splitwise.dtos.CreateExpenseDto;
import com.isudha.splitwise.exceptions.ResourceNotFound;
import com.isudha.splitwise.models.Expense;
import com.isudha.splitwise.models.User;
import com.isudha.splitwise.models.enums.ExpenseStatus;
import com.isudha.splitwise.repositories.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExpenseService {
    private ExpenseRepository expenseRepository;
    private UserService userService;

    public Expense createExpense(CreateExpenseDto request) {
        List<User> users = userService.findAllUsers(request.getUsers());

        User createdBy = users.stream().filter(user -> user.getId().equals(request.getCreatedBy())).findFirst().orElseThrow(() -> new ResourceNotFound("User not found."));

        Expense expense = Expense.builder()
                .description(request.getName())
                .amount(request.getAmount())
                .createdBy(createdBy)
                .status(ExpenseStatus.PENDING)
                .build();

        return expenseRepository.save(expense);
    }

    public Optional<Expense> findExpense(Long id) {
        return expenseRepository.findById(id);
    }
}
