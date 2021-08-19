package ua.com.alevel.type.service;

import ua.com.alevel.type.data.Personal;
import ua.com.alevel.type.data.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {

    void init(Personal from, Personal to, BigDecimal sum);
    List<Transaction> getAll();
    List<Transaction> getAllByPersonalFrom(Long id);
    List<Transaction> getAllByPersonalTo(Long id);


    // not business method
    void setBalanceService(BalanceService balanceService);
}
