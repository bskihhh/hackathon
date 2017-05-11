package com.getgobo.gobopay.dto;

import java.util.Objects;

public class MenuItem {
    private String itemId;
    private String name;
    private Money price;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(getItemId(), menuItem.getItemId()) &&
                Objects.equals(getName(), menuItem.getName()) &&
                Objects.equals(getPrice(), menuItem.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getName(), getPrice());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MenuItem{");
        sb.append("itemId='").append(itemId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
