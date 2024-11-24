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
		List<Person> persons;

		System.out.println("-----------------------------------------------");
		System.out.println("CONSULTA 1: Todos los registros  con findAll()");
		persons = personRepository.findAll();
		persons.stream().forEach(person -> System.out.println(person));

		System.out.println("-----------------------------------------------");
		System.out.println("CONSULTA 2: Todos los registros con findByProgrammingLanguage()");
		persons = personRepository.findByProgrammingLanguage("Python");
		persons.stream().forEach(person -> System.out.println(person));

		System.out.println("-----------------------------------------------");
		System.out
				.println("CONSULTA 3: Todos los registros con buscarByProgrammingLanguage(programmingLanguage, name)");
		persons = personRepository.buscarByProgrammingLanguage("Python", "Pepe");
		persons.stream().forEach(person -> System.out.println(person));

		System.out.println("-----------------------------------------------");
		System.out.println("CONSULTA 4: Todos los registros con buscarByProgrammingLanguage(programmingLanguage)");
		persons = personRepository.buscarByProgrammingLanguage("Java");
		persons.stream().forEach(person -> System.out.println(person));

		System.out.println("-----------------------------------------------");
		System.out.println("CONSULTA 5: Todos los registros con findByProgrammingLanguageAndName()");
		persons = personRepository.findByProgrammingLanguageAndName("Java", "Josefa");
		persons.stream().forEach(person -> System.out.println(person));
	}

}
