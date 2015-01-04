package com.kostya.todo.controller;

import com.kostya.todo.dao.TodoDao;
import com.kostya.todo.entity.Filter;
import com.kostya.todo.entity.TodoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Konstantin on 02.01.2015.
 */
@Controller
public class JsonTodoController {
    @Resource
    private TodoDao dao;
    private final static Logger logger = LoggerFactory.getLogger(JsonTodoController.class);

    @RequestMapping(value = "/json/todo/create", method = RequestMethod.PUT)
    public @ResponseBody TodoItem createTodo(@RequestBody TodoItem todo) {
        logger.info("Call of createTodo: {}", todo.toString());
        dao.save(todo);
        return todo;
    }

    @RequestMapping(value = "/json/todo/list", method = RequestMethod.POST)
    public @ResponseBody List<TodoItem> list(@RequestBody Filter filter) {
        logger.info("Test: {}",filter);
        return dao.list(filter);
    }

    @RequestMapping(value = "/json/todo/delete", method = RequestMethod.POST)
    public @ResponseBody TodoItem deleteTodo(@RequestBody TodoItem todo) {
        logger.info("Call of deleteTodo: {}", todo.toString());
        dao.delete(todo);
        return todo;
    }

    @RequestMapping(value = "/json/todo/update", method = RequestMethod.POST)
    public @ResponseBody boolean updateTodo(@RequestBody TodoItem todo) {
        logger.info("Call of updateTodo: {}", todo.toString());
        dao.update(todo);
        return true;
    }

    @RequestMapping(value = "/json/todo/toggle", method = RequestMethod.POST)
    public @ResponseBody TodoItem toggleTodo(@RequestBody TodoItem todo) {
        logger.info("Call of toggleTodo: {}", todo.toString());
        todo.setDone(!todo.isDone());
        dao.update(todo);
        return todo;
    }

}
