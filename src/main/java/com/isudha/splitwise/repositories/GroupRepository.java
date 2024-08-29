package com.isudha.splitwise.repositories;

import com.isudha.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
