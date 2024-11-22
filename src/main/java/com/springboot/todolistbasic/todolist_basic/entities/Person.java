package com.springboot.todolistbasic.todolist_basic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "programming_languague")
    private String programmingLanguague;

    public Person() {
    }

    public Person(Long id, String name, String lastName, String programmingLanguague) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.programmingLanguague = programmingLanguague;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProgrammingLanguague() {
        return programmingLanguague;
    }

    public void setProgrammingLanguague(String programmingLanguague) {
        this.programmingLanguague = programmingLanguague;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", programmingLanguague="
                + programmingLanguague + "]";
    }

}
