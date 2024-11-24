package com.springboot.todolistbasic.todolist_basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistBasicApplication {
	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(TodolistBasicApplication.class, args);
	}

}
