package com.kostya.todo.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Konstantin on 04.01.2015.
 */
public enum DoneType {
    NOT_DONE,DONE,ALL;

    @JsonValue
    public final String value() {
        return this.name();
    }
}
