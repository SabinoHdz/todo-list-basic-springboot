package com.springboot.todolistbasic.todolist_basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.todolistbasic.todolist_basic.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
