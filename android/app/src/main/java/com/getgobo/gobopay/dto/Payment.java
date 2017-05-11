package com.getgobo.gobopay.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Payment {
    private String orderId;
    private String card;
    private BigDecimal amount;

    public Payment(String orderId, String card, BigDecimal amount) {
        this.orderId = orderId;
        this.card = card;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCard() {
        return card;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getOrderId(), payment.getOrderId()) &&
                Objects.equals(getCard(), payment.getCard()) &&
                Objects.equals(getAmount(), payment.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getCard(), getAmount());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Payment{");
        sb.append("orderId='").append(orderId).append('\'');
        sb.append(", card='").append(card).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}