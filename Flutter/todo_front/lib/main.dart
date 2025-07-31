// lib/main.dart
import 'package:flutter/material.dart';
import 'package:todo_front/pages/todo_page.dart';
import 'services/todo_service.dart';
import 'models/todo.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: TodoPage(), //2
    );
  }
}
