package com.springboot.todolistbasic.todolist_basic.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMethod;

@RestController()
@RequestMapping("/todos")
public class TodoController {

    @GetMapping("/obtener")
    public Map<String, Object> getTodos() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Get all todos");
        response.put("status", 200);
        response.put("data", null);
        return response;
    }

    @GetMapping("/obtener/{id}")
    public String getTodo() {
        return "Get a todo";
    }

    // @RequestMapping(path = "/crear", method = RequestMethod.POST)
    @PostMapping("/crear")
    public String createTodo() {
        return "Create a todo";
    }

    @PutMapping("/actualizar/{id}")
    public String updateTodo() {
        return "Update a todo";
    }

    @PutMapping("/eliminar/{id}")
    public String deleteTodo() {
        return "Delete a todo";
    }
}
