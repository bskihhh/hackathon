package com.getgobo.gobopay.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private String currency = "CAD";
    private BigDecimal amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(getCurrency(), money.getCurrency()) &&
                Objects.equals(getAmount(), money.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrency(), getAmount());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Money{");
        sb.append("currency='").append(currency).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
