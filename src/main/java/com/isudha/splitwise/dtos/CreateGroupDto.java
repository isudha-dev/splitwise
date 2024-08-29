package com.isudha.splitwise.dtos;

import com.isudha.splitwise.models.Group;
import com.isudha.splitwise.services.UserService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class CreateGroupDto {

    private String name;
    private Long createdBy;
    private List<Long> memberIds = new ArrayList<>();
    private List<Long> adminIds = new ArrayList<>();

}
