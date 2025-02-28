#!/bin/bash
# Script to run all tests in sequence

echo "Creating a todo..."
hurl --variable todo_id=1 create-todo.hurl

echo "Getting all todos..."
hurl get-all-todos.hurl

echo "Getting todo by ID..."
hurl --variable todo_id=1 get-todo-by-id.hurl

echo "Updating todo..."
hurl --variable todo_id=1 update-todo.hurl

echo "Testing not found scenario..."
hurl not-found.hurl

echo "Testing validation error..."
hurl validation-error.hurl

echo "Deleting todo..."
hurl --variable todo_id=1 delete-todo.hurl

echo "All tests completed!"
