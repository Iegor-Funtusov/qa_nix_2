package ua.com.alevel.type.data;

import java.math.BigDecimal;

public class Balance extends BaseEntity {

    private Long userId;
    private BigDecimal balance;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "userId=" + userId +
                ", balance=" + balance +
                '}';
    }
}
