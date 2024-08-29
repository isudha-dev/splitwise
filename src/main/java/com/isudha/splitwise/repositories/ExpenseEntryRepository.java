package com.isudha.splitwise.repositories;

import com.isudha.splitwise.models.ExpenseEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseEntryRepository extends JpaRepository<ExpenseEntry, Long> {
}
