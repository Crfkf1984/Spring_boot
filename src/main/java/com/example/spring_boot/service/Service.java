package com.example.spring_boot.service;

import com.example.spring_boot.entity.Todo;

import java.util.List;

public interface Service {
    public List<Todo> getAllTodo();

    void save(Todo todo);

    Todo getTodo(int id);

    void remove(int id);

    void removeAllTodos(List<Todo> todos);
}
