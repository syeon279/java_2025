// lib/pages/todo_page.dart

import 'package:flutter/material.dart';
import '../services/todo_service.dart';
import '../models/todo.dart';

class TodoPage extends StatefulWidget {
  const TodoPage({Key? key}) : super(key: key);

  @override
  _TodoPageState createState() => _TodoPageState();
}

class _TodoPageState extends State<TodoPage> {
  List<Todo> todos = [];
  bool isLoading = true;

  @override
  void initState() {
    super.initState();
    loadTodos();
  }

  ///////////////////////////////////////
  void loadTodos() async {
    try {
      final result = await fetchTodos(); // service에서 호출
      setState(() {
        // 화면에 다시 렌더링
        todos = result;
        isLoading = false;
      });
    } catch (e) {
      print("할일 불러오기 실패: $e");
      setState(() {
        isLoading = false;
      });
    }
  }

  ///////////////////////////////////////
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('TODO 테스트')),
      body: isLoading
          ? const Center(
              child: CircularProgressIndicator(),
            )
          : ListView.builder(
              itemCount: todos.length,
              itemBuilder: (context, index) {
                final todo = todos[index];
                return ListTile(
                  title: Text(todo.title),
                  trailing: Icon(
                    todo.completed
                        ? Icons.check_circle
                        : Icons.radio_button_unchecked,
                    color: todo.completed ? Colors.green : Colors.grey,
                  ),
                );
              },
            ),
    );
  }
}
