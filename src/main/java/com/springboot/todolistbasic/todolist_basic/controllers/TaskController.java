package com.springboot.todolistbasic.todolist_basic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todolistbasic.todolist_basic.exceptions.TaskNotFoundException;
import com.springboot.todolistbasic.todolist_basic.models.Task;
import com.springboot.todolistbasic.todolist_basic.services.TaskServiceImpl;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        // implementación con Optional
        // Optional<Task> optinalTask = taskService.getTask(id);
        // if (!optinalTask.isPresent()) {
        // throw new TaskNotFoundException("La tarea no existe");
        // }

        // return optinalTask.get();

        // implementación sin optional
        Task task = taskService.getTask(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));

        return task;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return task;

    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task data) {
        Task updateTask = taskService.updateTask(id, data)
                .orElseThrow(() -> new TaskNotFoundException("Task for update not found"));
        return updateTask;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        Task taskDelete = taskService.deleteTask(id);
        if (taskDelete == null || taskDelete.equals(null)) {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok("Task deleted");

    }

}
