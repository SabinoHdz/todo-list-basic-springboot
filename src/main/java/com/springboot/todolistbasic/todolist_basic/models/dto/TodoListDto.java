package com.springboot.todolistbasic.todolist_basic.models.dto;

public class TodoListDto {
    private String title;
    private String description;
    private String done;

    public TodoListDto() {
    }

    public TodoListDto(String title, String description, String done) {
        this.title = title;
        this.description = description;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

}
