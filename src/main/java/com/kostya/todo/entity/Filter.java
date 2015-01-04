package com.kostya.todo.entity;

/**
 * Created by Konstantin on 04.01.2015.
 */
public class Filter {
    private DoneType type;
    private String sortField;
    private String sortDirection;

    public DoneType getType() {
        return type;
    }

    public void setType(DoneType type) {
        this.type = type;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "type=" + type +
                ", sortField='" + sortField + '\'' +
                ", sortDirection='" + sortDirection + '\'' +
                '}';
    }

    public Boolean getTypeAsBoolean() {
        return type.ordinal() == 1;
    }
}
