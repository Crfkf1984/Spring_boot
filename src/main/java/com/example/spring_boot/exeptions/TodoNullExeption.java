package com.example.spring_boot.exeptions;

public class TodoNullExeption extends RuntimeException{
    public TodoNullExeption(String message) {
        super(message);
    }
}
