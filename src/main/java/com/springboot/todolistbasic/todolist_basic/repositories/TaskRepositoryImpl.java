package com.springboot.todolistbasic.todolist_basic.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.todolistbasic.todolist_basic.models.Task;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private List<Task> tasks;

    public TaskRepositoryImpl() {
        this.tasks = new ArrayList<>(Arrays.asList(
                new Task(1L, "Tarea 1", "Descripcion 1", false),
                new Task(2L, "Tarea 2", "Descripcion 2", false),
                new Task(3L, "Tarea 3", "Descripcion 3", false),
                new Task(4L, "Tarea 4", "Descripcion 4", false),
                new Task(5L, "Tarea 5", "Descripcion 5", false)));
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Task findById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public void createTask(Task task) {
        if (task.getId() == null) {
            task.setId(tasks.size() + 1L);

        }
        this.tasks.add(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task taskSearch = this.findById(id);
        taskSearch.setTitle(task.getTitle());
        taskSearch.setDescription(task.getDescription());
        taskSearch.setDone(task.isDone());
        return taskSearch;

    }

    @Override
    public void deleteTask(Long id) {
        Task task = this.findById(id);
        tasks.remove(task);
    }
}
