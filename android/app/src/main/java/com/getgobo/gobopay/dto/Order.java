package com.getgobo.gobopay.dto;

import java.util.List;
import java.util.Objects;

public class Order {
    private String orderId;
    List<MenuItem> items;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getOrderId(), order.getOrderId()) &&
                Objects.equals(getItems(), order.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getItems());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderId='").append(orderId).append('\'');
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
