package com.getgobo.gobopay.dto;

import java.util.Objects;

public class TableId {
    private String tableId;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableId tableId1 = (TableId) o;
        return Objects.equals(tableId, tableId1.tableId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TableId{");
        sb.append("tableId='").append(tableId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
