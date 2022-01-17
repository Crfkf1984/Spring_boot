package com.example.spring_boot.dao;

import com.example.spring_boot.entity.Todo;

import java.util.List;

public interface TodoDao {
    public List<Todo> getAllTodo();

    void save(Todo todo);

    Todo getTodo(int id);

    void remove(int id);

    void removeAllTodos(List<Todo> todos);
}
