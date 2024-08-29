package com.isudha.splitwise.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class CreateGroupExpenseDto {
    private String expenseDescription;
    private Double expenseAmount;
    private Long expenseCreatedBy;
    private List<Long> expenseUsers = new ArrayList<>();
    private Long groupId;
}
