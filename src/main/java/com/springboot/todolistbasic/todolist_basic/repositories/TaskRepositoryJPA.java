package com.springboot.todolistbasic.todolist_basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.todolistbasic.todolist_basic.entities.Task;

public interface TaskRepositoryJPA extends JpaRepository<Task, Long> {

}
