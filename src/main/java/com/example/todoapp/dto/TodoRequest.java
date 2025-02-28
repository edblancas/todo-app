package com.example.todoapp.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

public class TodoRequest {
    @NotBlank(message = "Title is required")
    private String title;
    
    private String description;
    private boolean completed;

    // Getters and Setters
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoRequest that = (TodoRequest) o;
        return completed == that.completed &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, completed);
    }

    // toString
    @Override
    public String toString() {
        return "TodoRequest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
