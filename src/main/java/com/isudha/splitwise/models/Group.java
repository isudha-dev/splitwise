package com.isudha.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_groups")
public class Group extends BaseModel{
    private String name;
    @ManyToOne
    private User createdBy;
    @ManyToMany
    private List<User> members = new ArrayList<>();
    @ManyToMany
    private List<User> admins = new ArrayList<>();
}
