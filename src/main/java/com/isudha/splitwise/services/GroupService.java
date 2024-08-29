package com.isudha.splitwise.services;

import com.isudha.splitwise.dtos.CreateGroupDto;
import com.isudha.splitwise.dtos.CreateGroupExpenseDto;
import com.isudha.splitwise.exceptions.ResourceNotFound;
import com.isudha.splitwise.models.Expense;
import com.isudha.splitwise.models.Group;
import com.isudha.splitwise.models.GroupExpense;
import com.isudha.splitwise.models.User;
import com.isudha.splitwise.models.enums.ExpenseStatus;
import com.isudha.splitwise.repositories.ExpenseRepository;
import com.isudha.splitwise.repositories.GroupExpenseRepository;
import com.isudha.splitwise.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupService {
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    private GroupExpenseRepository groupExpenseRepository;
    private UserService userService;
    private ExpenseService expenseService;

    public Group createGroup(CreateGroupDto request){
        User createdBy = userService.findUser(request.getCreatedBy());
        List<User> members = userService.findAllUsers(request.getMemberIds());
        List<User> admins = userService.findAllUsers(request.getAdminIds());

        Group group = Group.builder()
                .name(request.getName())
                .createdBy(createdBy)
                .members(members)
                .admins(admins)
                .build();

        return groupRepository.save(group);
    }

    public Optional<Group> findGroup(Long id){
        return groupRepository.findById(id);
    }

    public GroupExpense createGroupExpense(CreateGroupExpenseDto request) {
        Group group = findGroup(request.getGroupId()).orElseThrow(() -> new ResourceNotFound("Group not found."));
        User createdBy = userService.findUser(request.getExpenseCreatedBy());
        List<User> users = userService.findAllUsers(request.getExpenseUsers());

        Expense expense = Expense.builder()
                .description(request.getExpenseDescription())
                .amount(request.getExpenseAmount())
                .createdBy(createdBy)
                .users(users)
                .status(ExpenseStatus.PENDING)
                .build();

        expenseRepository.save(expense);

        return groupExpenseRepository.save(new GroupExpense(group, expense));
    }
}
