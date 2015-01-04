package com.kostya.todo.entity;

import java.io.Serializable;

/**
 * Created by Konstantin on 02.01.2015.
 */


public class TodoItem  implements Serializable {
    private long id;
    private String text;
    private boolean done;

    public TodoItem() {}

    public TodoItem(String text) {
        this.text = text;
        this.done = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", done=" + done +
                '}';
    }
}
