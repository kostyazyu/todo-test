package com.kostya.todo.dao;

import com.kostya.todo.entity.DoneType;
import com.kostya.todo.entity.Filter;
import com.kostya.todo.entity.TodoItem;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

public class TodoDaoImpl extends HibernateDaoSupport implements TodoDao {

    @Override
    public void save(TodoItem todo) {
        getHibernateTemplate().save(todo);
    }

    @Override
    public void update(TodoItem todo) {
        getHibernateTemplate().update(todo);
    }

    @Override
    public void delete(TodoItem todo) {
        getHibernateTemplate().delete(todo);
    }

    @Override
    public List<TodoItem> list(Filter filter) {
//        getHibernateTemplate().set
        if (DoneType.ALL.equals(filter.getType())) {
            return (List<TodoItem>) getHibernateTemplate().find("from TodoItem order by " + filter.getSortField() + " " + filter.getSortDirection());
        } else {
            return (List<TodoItem>) getHibernateTemplate().find("from TodoItem where done=? order by " + filter.getSortField() + " "
                            + filter.getSortDirection(),
                    filter.getTypeAsBoolean());
        }
    }

    @Override
    public List<TodoItem> list() {
        return (List<TodoItem>) getHibernateTemplate().find("from TodoItem");
    }


}
