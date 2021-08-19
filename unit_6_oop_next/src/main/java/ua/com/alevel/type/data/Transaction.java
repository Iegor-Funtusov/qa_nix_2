package ua.com.alevel.type.data;

import java.math.BigDecimal;

public class Transaction extends BaseEntity {

    private Long from;
    private Long to;
    private BigDecimal sum;

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "from=" + from +
                ", to=" + to +
                ", sum=" + sum +
                '}';
    }
}
