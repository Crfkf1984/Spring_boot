package com.example.spring_boot.dao;

import com.example.spring_boot.entity.Todo;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TodoDaoImpl implements TodoDao {
 private EntityManager manager;

    @Autowired
    public TodoDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Todo> getAllTodo() {
        //Session session = manager.unwrap(Session.class);
        List<Todo> list = manager.createQuery("from Todo ", Todo.class).getResultList();
        return list;
    }

    @Override
    public void save(Todo todo) {
        //Session session = manager.unwrap(Session.class);
       // manager.saveOrUpdate(todos);
        Todo todos = manager.merge(todo);
        todo.setId(todos.getId());
    }

    @Override
    public Todo getTodo(int id) {
       // Session session = manager.unwrap(Session.class);
        Todo todos = manager.find(Todo.class, id);
        return todos;
    }

    @Override
    public void remove(int id) {
        //Session session = manager.unwrap(Session.class);
        Todo todos = manager.find(Todo.class, id);
        manager.remove(todos);
    }

    @Override
    public void removeAllTodos(List<Todo> list) {
        //Session session = manager.unwrap(Session.class);
        for (Todo todos : list) {
            manager.remove(todos);
        }

    }
}
