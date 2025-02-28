package com.example.todoapp.service;

import com.example.todoapp.dto.TodoRequest;
import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(TodoRequest todoRequest) {
        Todo todo = new Todo();
        todo.setTitle(todoRequest.getTitle());
        todo.setDescription(todoRequest.getDescription());
        todo.setCompleted(todoRequest.isCompleted());
        return todoRepository.save(todo);
    }

    public Optional<Todo> updateTodo(Long id, TodoRequest todoRequest) {
        Optional<Todo> existingTodo = todoRepository.findById(id);
        
        if (existingTodo.isPresent()) {
            Todo todo = existingTodo.get();
            todo.setTitle(todoRequest.getTitle());
            todo.setDescription(todoRequest.getDescription());
            todo.setCompleted(todoRequest.isCompleted());
            return Optional.of(todoRepository.save(todo));
        }
        
        return Optional.empty();
    }

    public boolean deleteTodo(Long id) {
        return todoRepository.deleteById(id);
    }
}
