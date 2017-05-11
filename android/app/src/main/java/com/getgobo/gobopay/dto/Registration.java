package com.getgobo.gobopay.dto;

import java.util.Objects;

public class Registration {
    private String tableId;
    private String orderId;

    public String getTableId() {

        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

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
        Registration that = (Registration) o;
        return Objects.equals(getTableId(), that.getTableId()) &&
                Objects.equals(getOrderId(), that.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTableId(), getOrderId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Registration{");
        sb.append("tableId='").append(tableId).append('\'');
        sb.append(", orderId='").append(orderId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
