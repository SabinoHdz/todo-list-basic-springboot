package com.springboot.todolistbasic.todolist_basic.repositories;

import java.util.List;
import java.util.Optional;

import com.springboot.todolistbasic.todolist_basic.models.Task;

public interface TaskRepository {

    List<Task> findAll();

    Task findById(Long id);

    void createTask(Task task);

    Task updateTask(Long id, Task task);

    Optional<Task> deleteTask(Long id);

}
