package com.springboot.todolistbasic.todolist_basic.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.todolistbasic.todolist_basic.models.dto.TodoFilterDto;
import com.springboot.todolistbasic.todolist_basic.models.dto.TodoListDto;

@RestController()
@RequestMapping("/todos")
public class TodoController {

    @GetMapping("/obtener")
    public List<TodoListDto> getTodos() {
        List<TodoListDto> todos = new ArrayList<>();
        todos.add(new TodoListDto("Title 1", "Description 1", "Done 1"));
        todos.add(new TodoListDto("Title 2", "Description 2", "Done 2"));
        todos.add(new TodoListDto("Title 3", "Description 3", "Done 3"));
        return todos;

    }

    @GetMapping("/obtener/{id}")
    public TodoListDto getTodo() {
        TodoListDto todoListDto = new TodoListDto();
        todoListDto.setTitle("Title");
        todoListDto.setDescription("Description");
        todoListDto.setDone("Done");
        return todoListDto;
    }

    // @RequestMapping(path = "/crear", method = RequestMethod.POST)
    @PostMapping("/crear")
    public String createTodo() {
        return "Create a todo";
    }

    @PutMapping("/actualizar/{id}")
    public String updateTodo() {
        return "Update a todo";
    }

    @PutMapping("/eliminar/{id}")
    public String deleteTodo() {
        return "Delete a todo";
    }

    @GetMapping("/filter")
    public TodoFilterDto filterTodos(@RequestParam(required = false, defaultValue = "todo filter") String filter,
            @RequestParam String title, @RequestParam(required = false) String description,
            @RequestParam(required = false) String done) {
        TodoFilterDto todoFilterDto = new TodoFilterDto();
        todoFilterDto.setFilter(filter);
        todoFilterDto.setTitle(title);
        todoFilterDto.setDescription(description);
        todoFilterDto.setDone(done);
        return todoFilterDto;
    }

    @GetMapping("/getTodo/{id}")
    public Map<String, Object> getTodoById(@PathVariable String id) {
        Map<String, Object> response = Map.of("id", id, "message", "get a todo by path variable");
        return response;
    }
}
