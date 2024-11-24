package com.springboot.todolistbasic.todolist_basic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.todolistbasic.todolist_basic.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // nomeclatura de consultas query methods
    List<Person> findByProgrammingLanguage(String programmingLanguage);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

    // consultas personalizadas de JPA Query
    @Query("select p from Person p where p.programmingLanguage = ?1")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage);

    @Query("select p from Person p where p.programmingLanguage = ?1 and p.name=?2")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage, String name);

    // Lista de valores de la consulta
    @Query("select p.name,p.lastName from Person p")
    List<Object[]> obtenerPersonData();

}
