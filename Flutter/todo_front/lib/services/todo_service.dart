//192.168.40.177

import 'package:http/http.dart' as http;
import 'dart:convert';
import '../models/todo.dart';

Future<List<Todo>> fetchTodos() async {
  final response =
      await http.get(Uri.parse("http://192.168.40.177:8080/api/todos"));

  if (response.statusCode == 200) {
    final decoded = utf8.decode(response.bodyBytes);
    List<dynamic> jsonData = json.decode(decoded);
    return jsonData.map((item) => Todo.fromJson(item)).toList();
  } else {
    throw Exception("API 호출 실해: ${response.statusCode}");
  }
}

  

//http://localhost:8080/api/todos