package ua.com.alevel.type.service.impl;

import ua.com.alevel.type.data.Balance;
import ua.com.alevel.type.data.Personal;
import ua.com.alevel.type.data.Transaction;
import ua.com.alevel.type.service.BalanceService;
import ua.com.alevel.type.service.TransactionService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    List<Transaction> transactions = new ArrayList<>();
    private BalanceService balanceService;

    @Override
    public void init(Personal from, Personal to, BigDecimal sum) {
        Transaction transaction = new Transaction();
        transaction.setFrom(from.getId());
        transaction.setTo(to.getId());
        transaction.setSum(sum);
        transactions.add(transaction);

        balanceService.update(from, sum, false);
        balanceService.update(to, sum, true);
    }

    @Override
    public List<Transaction> getAll() {
        return transactions;
    }

    @Override
    public List<Transaction> getAllByPersonalFrom(Long id) {
        return null;
    }

    @Override
    public List<Transaction> getAllByPersonalTo(Long id) {
        return null;
    }

    @Override
    public void setBalanceService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }
}
