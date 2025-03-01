package com.example.todoapp.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

public class TodoRequest {
    @NotBlank(message = "Id is required")
    private String id; // Accept the id as a string from the JSON request

    @NotBlank(message = "Title is required")
    private String title;
    private boolean completed;

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // equals and hashCode (including id)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoRequest that = (TodoRequest) o;
        return completed == that.completed &&
                Objects.equals(id, that.id) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, completed);
    }

    // toString
    @Override
    public String toString() {
        return "TodoRequest{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
