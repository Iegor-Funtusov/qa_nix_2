package ua.com.alevel.type.service.impl;

import ua.com.alevel.type.data.Balance;
import ua.com.alevel.type.data.Personal;
import ua.com.alevel.type.service.BalanceService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BalanceServiceImpl implements BalanceService {

    private List<Balance> balances = new ArrayList<>();

    @Override
    public void create(Personal personal, BigDecimal balance) {
        Balance balance1 = getBalanceByPersonalId(personal.getId());
        if (balance1 == null) {
            balance1 = new Balance();
            balance1.setUserId(personal.getId());
        }
        balance1.setBalance(balance);
        balances.add(balance1);
    }

    @Override
    public void update(Personal personal, BigDecimal balance, boolean up) {
        Balance balance1 = getBalanceByPersonalId(personal.getId());
        if (up) {
            balance1.setBalance(balance1.getBalance().add(balance));
        } else {
            balance1.setBalance(balance1.getBalance().subtract(balance));
        }
    }

    @Override
    public Balance getBalanceByPersonalId(Long id) {
        return balances
                .stream()
                .filter(b -> b.getUserId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Balance> findAll() {
        return balances;
    }
}
