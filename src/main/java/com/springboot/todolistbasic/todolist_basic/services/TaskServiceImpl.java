package com.springboot.todolistbasic.todolist_basic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.todolistbasic.todolist_basic.entities.Task;
import com.springboot.todolistbasic.todolist_basic.repositories.TaskRepositoryJPA;

@Service
public class TaskServiceImpl implements TaskServiceJPA {
    @Autowired
    private TaskRepositoryJPA taskRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Task> findById(Long id) {

        return taskRepository.findById(id);
    }

    @Override
    @Transactional
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public Optional<Task> deleted(Task task) {
        Optional<Task> taskDB = taskRepository.findById(task.getId());
        taskDB.ifPresent(t -> taskRepository.delete(t));
        return taskDB;
    }

    @Override
    @Transactional
    public void deletedById(Long id) {
        taskRepository.deleteById(id);
    }

}
