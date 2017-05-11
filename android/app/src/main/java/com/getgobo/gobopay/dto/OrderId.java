package com.getgobo.gobopay.dto;

import java.util.Objects;

public class OrderId {
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderId tableId1 = (OrderId) o;
        return Objects.equals(orderId, tableId1.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderId{");
        sb.append("orderId='").append(orderId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
