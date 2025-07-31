// lib/services/todo_service.dart
//192.168.40.169
//http://localhost:8080/api/todos
//http://192.168.40.169:8080/api/todos
import 'package:http/http.dart' as http;
import 'dart:convert';
import '../models/todo.dart';

/////  read
Future<List<Todo>> fetchTodos() async {
  final response =
      await http.get(Uri.parse("http://192.168.40.169:8080/api/todos"));

  if (response.statusCode == 200) {
    final decoded = utf8.decode(response.bodyBytes);
    List<dynamic> jsonData = json.decode(decoded);
    return jsonData.map((item) => Todo.fromJson(item)).toList();
  } else {
    throw Exception("API 호출실패: ${response.statusCode}");
  }
}

/////  create
Future<void> addTodoToService(String title) async {
  final response = await http.post(
      Uri.parse("http://192.168.40.169:8080/api/todos"),
      headers: {"Content-type": "application/json; charset=UTF-8"},
      body: json.encode({"title": title, "completed": false}));

  if (response.statusCode != 201) {
    throw Exception("할 일 추가 실패: ${response.statusCode}");
  }
}

/////  delete
Future<void> deleteTodo(int id) async {
  final response =
      await http.delete(Uri.parse("http://192.168.40.169:8080/api/todos/$id"));

  if (response.statusCode != 200 && response.statusCode != 204) {
    throw Exception("삭제 실패");
  }
}

/////  update
Future<void> updateTodoOnService(Todo todo) async {
  final response = await http.put(
      Uri.parse("http://192.168.40.169:8080/api/todos/${todo.id}"),
      headers: {"Content-type": "application/json; charset=UTF-8"},
      body: json.encode(todo.toJson()));

  if (response.statusCode != 200) {
    throw Exception("업데이트 실패");
  }
}
