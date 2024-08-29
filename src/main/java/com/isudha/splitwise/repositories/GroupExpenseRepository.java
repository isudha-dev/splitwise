package com.isudha.splitwise.repositories;

import com.isudha.splitwise.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Long> {
}
