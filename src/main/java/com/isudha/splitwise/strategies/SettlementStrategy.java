package com.isudha.splitwise.strategies;

import com.isudha.splitwise.dtos.SettleUpTransaction;
import com.isudha.splitwise.models.Expense;

import java.util.List;

public interface SettlementStrategy {

    List<SettleUpTransaction> settleUp(List<Expense> expenses);
}
