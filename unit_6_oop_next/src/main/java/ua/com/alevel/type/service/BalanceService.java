package ua.com.alevel.type.service;

import ua.com.alevel.type.data.Balance;
import ua.com.alevel.type.data.Personal;

import java.math.BigDecimal;
import java.util.List;

public interface BalanceService {

    void create(Personal personal, BigDecimal balance);
    void update(Personal personal, BigDecimal balance, boolean up);
    Balance getBalanceByPersonalId(Long id);
    List<Balance> findAll();
}
