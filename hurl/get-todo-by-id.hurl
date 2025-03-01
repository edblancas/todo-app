# get-todo-by-id.hurl
# Test retrieving a specific todo
# Note: You should run create-todo.hurl first, or replace {todo_id} with an actual ID
GET http://localhost:8080/api/todos/{{todo_id}}

HTTP/1.1 200
[Asserts]
jsonpath "$.id" == {{todo_id}}
jsonpath "$.title" exists
jsonpath "$.completed" exists

