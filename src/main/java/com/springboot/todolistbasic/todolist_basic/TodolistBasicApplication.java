package com.springboot.todolistbasic.todolist_basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.todolistbasic.todolist_basic.entities.Person;
import com.springboot.todolistbasic.todolist_basic.repositories.PersonRepository;

@SpringBootApplication
public class TodolistBasicApplication implements CommandLineRunner {
	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodolistBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// aplicación de consola

		List<Person> persons = personRepository.findAll();
		persons.stream().forEach(person -> System.out.println(person));
	}

}
