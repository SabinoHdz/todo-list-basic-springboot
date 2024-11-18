package com.springboot.todolistbasic.todolist_basic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.todolistbasic.todolist_basic.exceptions.TaskNotFoundException;
import com.springboot.todolistbasic.todolist_basic.models.Task;
import com.springboot.todolistbasic.todolist_basic.repositories.TaskRepositoryImpl;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepositoryImpl taskRepository;

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTask(Long id) {
        Task task = taskRepository.findById(id);
        return Optional.ofNullable(task);
    }

    public void createTask(Task task) {
        taskRepository.createTask(task);
    }

    public Optional<Task> updateTask(Long id, Task task) {
        Task updateTask = taskRepository.updateTask(id, task);
        return Optional.ofNullable(updateTask);
    }

    public Task deleteTask(Long id) {
        Task deleteTask = taskRepository.deleteTask(id)
                .orElseThrow(() -> new TaskNotFoundException("Errorr: Not found task"));
        return deleteTask;
    }
}
