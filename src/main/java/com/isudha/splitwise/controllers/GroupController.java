package com.isudha.splitwise.controllers;

import com.isudha.splitwise.dtos.CreateGroupDto;
import com.isudha.splitwise.dtos.CreateGroupExpenseDto;
import com.isudha.splitwise.models.Group;
import com.isudha.splitwise.models.GroupExpense;
import com.isudha.splitwise.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class GroupController {

    private GroupService groupService;

    public Group createGroup(CreateGroupDto request){
        return groupService.createGroup(request);
    }

    public GroupExpense createGroupExpense(CreateGroupExpenseDto request) {
        return groupService.createGroupExpense(request);
    }

}
