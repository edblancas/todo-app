# delete-todo.hurl
# Test deleting a todo
# Note: You should run create-todo.hurl first, or replace {todo_id} with an actual ID
DELETE http://localhost:8080/api/todos/{{todo_id}}

HTTP/1.1 204

# Verify the todo is deleted
GET http://localhost:8080/api/todos/{{todo_id}}

HTTP/1.1 404
