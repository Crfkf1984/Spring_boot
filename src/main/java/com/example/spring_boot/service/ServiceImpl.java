package com.example.spring_boot.service;


import com.example.spring_boot.dao.TodoDao;
import com.example.spring_boot.entity.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    private TodoDao todoDao;

    @Autowired
    public ServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    @Transactional
    public List<Todo> getAllTodo() {
        return todoDao.getAllTodo();
    }

    @Override
    @Transactional
    public void save(Todo todo) {
        todoDao.save(todo);
    }

    @Override
    @Transactional
    public Todo getTodo(int id) {
        log.info("Start method!!!");
        Todo todos = todoDao.getTodo(id);
        if (todos == null) {
            log.warn("Такого дела нет!!!");
            throw new RuntimeException("Такого дела нет!!!");
        }
        return todoDao.getTodo(id);
    }

    @Override
    @Transactional
    public void remove(int id) {
        todoDao.remove(id);

    }

    @Override
    @Transactional
    public void removeAllTodos(List<Todo> todos) {
        todoDao.removeAllTodos(todos);
    }
}
