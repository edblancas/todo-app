package com.example.todoapp.service;

import com.example.todoapp.dto.TodoRequest;
import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(String id) {
        return todoRepository.findById(UUID.fromString(id));
    }

    public Todo createTodo(TodoRequest todoRequest) {
        Todo todo = new Todo();
        todo.setTitle(todoRequest.getTitle());
        todo.setCompleted(todoRequest.isCompleted());
        todo.setId(UUID.fromString(todoRequest.getId()));
        return todoRepository.save(todo);
    }

    public Optional<Todo> updateTodo(String id, TodoRequest todoRequest) {
        Optional<Todo> existingTodo = todoRepository.findById(UUID.fromString(id));
        
        if (existingTodo.isPresent()) {
            Todo todo = existingTodo.get();
            var title = todoRequest.getTitle();
            if (title != null)
                todo.setTitle(title);
            todo.setCompleted(todoRequest.isCompleted());
            return Optional.of(todoRepository.update(todo));
        }
        
        return Optional.empty();
    }

    public boolean deleteTodo(String id) {
        return todoRepository.deleteById(UUID.fromString(id));
    }
}
