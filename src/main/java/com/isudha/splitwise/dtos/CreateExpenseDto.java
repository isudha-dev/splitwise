package com.isudha.splitwise.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class CreateExpenseDto {
    private String name;
    private Double amount;
    private Long createdBy;
    private List<Long> users = new ArrayList<>();

}
