#!/bin/bash
# Script to run all tests in sequence

todoId=$(uuidgen)
# Convert the generated UUID to lowercase
todoId=$(echo "$todoId" | tr '[:upper:]' '[:lower:]')

echo "Creating a todo..."
hurl --variable todo_id=$todoId create-todo.hurl

echo "Getting all todos..."
hurl get-all-todos.hurl

echo "Getting todo by ID..."
hurl --variable todo_id=$todoId get-todo-by-id.hurl

echo "Updating todo..."
hurl --variable todo_id=$todoId update-todo.hurl

echo "Testing not found scenario..."
hurl not-found.hurl

echo "Testing validation error..."
hurl validation-error.hurl

echo "Deleting todo..."
hurl --variable todo_id=$todoId delete-todo.hurl

echo "All tests completed!"
