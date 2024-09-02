package com.isudha.splitwise.strategies;

import com.isudha.splitwise.dtos.SettleUpTransaction;
import com.isudha.splitwise.models.Expense;
import com.isudha.splitwise.models.ExpenseEntry;
import com.isudha.splitwise.models.User;
import org.springframework.stereotype.Component;
import org.springframework.data.util.Pair;

import java.util.*;

@Component
public class GreedySettlementStrategy implements SettlementStrategy {
    @Override
    public List<SettleUpTransaction> settleUp(List<Expense> expenses) {
        Map<Long, Double> initialState = prepareInitialStage(expenses);
        TreeSet<Pair<Long, Double>> expenseTree = new TreeSet<>((a, b) -> (int) (a.getSecond() - b.getSecond()));

        for (Map.Entry<Long, Double> entry: initialState.entrySet()) {
            expenseTree.add(Pair.of(entry.getKey(), entry.getValue()));
        }

        List<SettleUpTransaction> output = new ArrayList<>();

        while (!expenseTree.isEmpty()) {
            Pair<Long, Double> smallest = expenseTree.first();
            Pair<Long, Double> largest = expenseTree.last();

            SettleUpTransaction transaction = SettleUpTransaction.builder()
                    .from(largest.getFirst())
                    .to(smallest.getFirst())
                    .amount(largest.getSecond())
                    .build();

            output.add(transaction);
            expenseTree.remove(smallest);
            expenseTree.remove(largest);
            expenseTree.add(Pair.of(smallest.getFirst(), smallest.getSecond() + largest.getSecond()));

        }

        return output;
    }

    public Map<Long, Double> prepareInitialStage(List<Expense> expenses) {
        Map<Long, Double> transactions = new HashMap<>();

        for (Expense expense: expenses) {
            for (ExpenseEntry expenseEntry: expense.getPaidBy()) {
                User user = expenseEntry.getUser();
                if(!transactions.containsKey(user.getId())) {
                    transactions.put(user.getId(), 0.0);
                }
                transactions.put(user.getId(), transactions.get(user.getId()) + expenseEntry.getAmount());
            }

            for (ExpenseEntry expenseEntry: expense.getOwedBy()) {
                User user = expenseEntry.getUser();
                if(!transactions.containsKey(user.getId())) {
                    transactions.put(user.getId(), 0.0);
                }
                transactions.put(user.getId(), transactions.get(user.getId()) - expenseEntry.getAmount());
            }
        }

        return transactions;
    }
}
