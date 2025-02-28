# not-found.hurl
# Test handling non-existent todo
GET http://localhost:8080/api/todos/9999

HTTP/1.1 404

