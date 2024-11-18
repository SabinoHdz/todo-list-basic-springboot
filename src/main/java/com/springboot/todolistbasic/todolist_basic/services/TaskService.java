package com.springboot.todolistbasic.todolist_basic.services;

import java.util.List;
import java.util.Optional;

import com.springboot.todolistbasic.todolist_basic.models.Task;

public interface TaskService {
    List<Task> getTasks();

    Optional<Task> getTask(Long id);

    void createTask(Task task);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);

}
