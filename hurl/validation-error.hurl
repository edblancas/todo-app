# validation-error.hurl
# Test validation error (empty title)
POST http://localhost:8080/api/todos
Content-Type: application/json

{
    "title": "",
    "description": "This should fail validation",
    "completed": false
}

HTTP/1.1 400
