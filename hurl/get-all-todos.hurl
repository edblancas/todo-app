# get-all-todos.hurl
# Test retrieving all todos
GET http://localhost:8080/api/todos

HTTP/1.1 200
[Asserts]
jsonpath "$" isCollection
jsonpath "$[0]" exists # At least one todo should exist

