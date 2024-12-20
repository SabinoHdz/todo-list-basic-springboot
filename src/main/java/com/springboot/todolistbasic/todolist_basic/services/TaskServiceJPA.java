package com.springboot.todolistbasic.todolist_basic.services;

import java.util.List;
import java.util.Optional;

import com.springboot.todolistbasic.todolist_basic.entities.Task;

public interface TaskServiceJPA {

    List<Task> findAll();

    Optional<Task> findById(Long id);

    Task save(Task task);

    Optional<Task> update(Long id, Task task);

    Optional<Task> deleted(Long id);

    void deletedById(Long id);
}
