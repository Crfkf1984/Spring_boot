package com.example.spring_boot.controller;

import com.example.spring_boot.entity.Todo;
import com.example.spring_boot.exeptions.TodoNullExeption;
import com.example.spring_boot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    private Service service;

    @Autowired
    public MyController(Service service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public List<Todo> getTodoList() {
        List<Todo> list = service.getAllTodo();
        return list;
    }

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable int id) {
        Todo todos = service.getTodo(id);
        if (todos == null) {
            throw new TodoNullExeption("такого " + id + " нет!");
        }
        return todos;
    }

    @PostMapping("/todos/")
    public Todo addtodo(@Validated @RequestBody Todo todos) {
        service.save(todos);
        return todos;
    }

    @PutMapping("/todos/")
    public Todo chengeTodo(@RequestBody Todo todos) {
        service.save(todos);
        return todos;
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodo(@PathVariable int id) {
        Todo todo = service.getTodo(id);
        if (todo == null) {
            throw new TodoNullExeption("Такого дела нет!!!");
        }
        service.remove(id);
        return "Todo with ID = " + id + " was deleted";
    }

    @DeleteMapping("/todos/")
    public String deleteTodo() {
        List<Todo> list = service.getAllTodo();
        if (list.isEmpty()) {
            throw new TodoNullExeption("Все дела уже удалены !!!");
        }

        service.removeAllTodos(list);
        return "All Todo was deleted";
    }

}
