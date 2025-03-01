package com.example.todoapp.repository;

import com.example.todoapp.model.Todo;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TodoRepository {
    private final List<Todo> todos = new ArrayList<>();

    public List<Todo> findAll() {
        return new ArrayList<>(todos);
    }

    public Optional<Todo> findById(UUID id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst();
    }

    public Todo save(Todo todo) {
        // Creating a new todo
        todo.setCreatedAt(LocalDateTime.now());
        todo.setUpdatedAt(LocalDateTime.now());
        todos.add(todo);
        return todo;
    }

    public Todo update(Todo todo) {
        // Updating an existing todo
        todos.removeIf(t -> t.getId().equals(todo.getId()));
        todo.setUpdatedAt(LocalDateTime.now());
        todos.add(todo);
        return todo;
    }

    public boolean deleteById(UUID id) {
        return todos.removeIf(todo -> todo.getId().equals(id));
    }
}
