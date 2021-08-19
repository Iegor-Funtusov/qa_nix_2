package ua.com.alevel;

import ua.com.alevel.type.data.*;
import ua.com.alevel.type.service.BalanceService;
import ua.com.alevel.type.service.TransactionService;
import ua.com.alevel.type.service.impl.BalanceServiceImpl;
import ua.com.alevel.type.service.impl.TransactionServiceImpl;
import ua.com.alevel.type.util.MathUtil;

import java.math.BigDecimal;
import java.util.List;

public class OopNextMain {

    public static void main(String[] args) {

        // service class
        Personal from = new Personal();
        from.setId(1L);

        Personal to = new Personal();
        to.setId(2L);

        BalanceService balanceService = new BalanceServiceImpl();
        balanceService.create(from, new BigDecimal("100.00"));
        balanceService.create(to, new BigDecimal("10.00"));

        List<Balance> balances = balanceService.findAll();
        balances.forEach(System.out::println);

        TransactionService transactionService = new TransactionServiceImpl();
        transactionService.setBalanceService(balanceService);
        transactionService.init(from, to, new BigDecimal("20.00"));

        balances = balanceService.findAll();
        balances.forEach(System.out::println);

        List<Transaction> transactions = transactionService.getAll();
        transactions.forEach(System.out::println);




        // util class
//        double sqrt = MathUtil.sqrt(10);
//        System.out.println("sqrt = " + sqrt);

        // data class
//        User user1 = new Personal();
//        user1.setId(1L);
//        user1.setLogin("test1");
//        user1.setName("name1");
//
//        User user2 = new Admin();
//        user2.setId(1L);
//        user2.setLogin("test1");
//        user2.setName("name1");
//
//        User user3 = new Admin();
//        user3.setId(1L);
//        user3.setLogin("test1");
//        user3.setName("name1");
//
//        System.out.println(user3.equals(user2));
//        System.out.println(user3.hashCode() == user2.hashCode());
    }
}
