package com.getgobo.gobopay.dto;

import java.util.Objects;

public class Restaurant {
    private String restaurantId;
    private String restaurantName;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant server = (Restaurant) o;
        return Objects.equals(getRestaurantId(), server.getRestaurantId()) &&
                Objects.equals(getRestaurantName(), server.getRestaurantName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRestaurantId(), getRestaurantName());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Server{");
        sb.append("restaurantId='").append(restaurantId).append('\'');
        sb.append(", restaurantName='").append(restaurantName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
