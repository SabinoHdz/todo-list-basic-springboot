package com.springboot.todolistbasic.todolist_basic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistBasicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodolistBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// aplicación de consola
	}

}
