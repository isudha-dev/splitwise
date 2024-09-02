package com.isudha.splitwise.dtos;

import com.isudha.splitwise.models.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SettleUpTransaction {
    private Long from;
    private Long to;
    private Double amount;
}
