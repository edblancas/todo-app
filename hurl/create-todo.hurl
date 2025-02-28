# create-todo.hurl
# Test creating a new todo
POST http://localhost:8080/api/todos
Content-Type: application/json

{
    "title": "Buy groceries",
    "description": "Milk, eggs, bread, and vegetables",
    "completed": false
}

HTTP/1.1 201
[Asserts]
jsonpath "$.id" exists
jsonpath "$.title" == "Buy groceries"
jsonpath "$.description" == "Milk, eggs, bread, and vegetables"
jsonpath "$.completed" == false
jsonpath "$.createdAt" exists
jsonpath "$.updatedAt" exists

# Capture the created todo ID for later tests
[Captures]
todo_id: jsonpath "$.id"

