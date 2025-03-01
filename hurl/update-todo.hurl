# update-todo.hurl
# Test updating a todo
# Note: You should run create-todo.hurl first, or replace {todo_id} with an actual ID
PUT http://localhost:8080/api/todos/{{todo_id}}
Content-Type: application/json

{
    "title": "Buy groceries - UPDATED",
    "completed": true
}

HTTP/1.1 200
[Asserts]
jsonpath "$.id" == {{todo_id}}
jsonpath "$.title" == "Buy groceries - UPDATED"
jsonpath "$.completed" == true
jsonpath "$.updatedAt" exists
