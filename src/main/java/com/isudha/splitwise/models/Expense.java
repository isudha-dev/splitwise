package com.isudha.splitwise.models;

import com.isudha.splitwise.models.enums.ExpenseStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_expenses")
public class Expense extends BaseModel{

    private String description;
    private Double amount;
    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "expense")
    private List<ExpenseEntry> paidBy = new ArrayList<>();

    @OneToMany(mappedBy = "expense")
    private List<ExpenseEntry> owedBy = new ArrayList<>();

    @Enumerated
    private ExpenseStatus status;

}
