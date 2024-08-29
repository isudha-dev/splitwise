package com.isudha.splitwise.models;

import com.isudha.splitwise.models.enums.ExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GroupExpense extends BaseModel{
    @ManyToOne
    private Group group;
    @ManyToOne
    private Expense expense;
}
