package com.springboot.todolistbasic.todolist_basic.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todolistbasic.todolist_basic.entities.Task;
import com.springboot.todolistbasic.todolist_basic.services.TaskServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping
    public List<Task> getTasks() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        // implementación con Optional
        // Optional<Task> optinalTask = taskService.getTask(id);
        // if (!optinalTask.isPresent()) {
        // throw new TaskNotFoundException("La tarea no existe");
        // }

        // return optinalTask.get();

        // implementación sin optional
        // Task task = taskService.findById(id).orElseThrow(() -> new
        // TaskNotFoundException("Task not found"));
        // return task;

        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createTask(@Valid @RequestBody Task task, BindingResult result) {

        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Task taskCreate = taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @Valid @RequestBody Task data, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Optional<Task> task = taskService.update(id, data);
        if (!task.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(task.orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {

        Optional<Task> taskDelete = taskService.deleted(id);
        if (!taskDelete.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(taskDelete.orElseThrow());
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "El Campo " + error.getField() + " " + error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
