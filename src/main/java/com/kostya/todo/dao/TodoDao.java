package com.kostya.todo.dao;

import com.kostya.todo.entity.Filter;
import com.kostya.todo.entity.TodoItem;

import java.util.List;

public interface TodoDao {
    void save(TodoItem todo);
    void update(TodoItem todo);
    void delete(TodoItem todo);
    List<TodoItem> list();
    List<TodoItem> list(Filter filter);
    // TodoItem findByTodoName(String name); // or list???
}
