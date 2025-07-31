// lib/pages/todo_page.dart
import 'package:flutter/material.dart';
import '../services/todo_service.dart';
import '../models/todo.dart';

class TodoPage extends StatefulWidget {
  //#3
  const TodoPage({Key? key}) : super(key: key);

  @override
  _TodoPageState createState() => _TodoPageState();
}

class _TodoPageState extends State<TodoPage> {
  List<Todo> todos = [];
  bool isLoading = true;
  final TextEditingController _textController =
      TextEditingController(); //# 추가된 부분

  @override
  void initState() {
    super.initState();
    loadTodos();
  }

  ///////////////////////////////////////  list
  void loadTodos() async {
    try {
      final result = await fetchTodos();
      setState(() {
        todos = result;
        isLoading = false;
      });
    } catch (e) {
      print("할 일 불러오기 실패: $e");
      setState(() => isLoading = false);
    }
  }

  ///////////////////////////////////////  post - create
  // 글쓰면 리스트에 즉시반영
  void _addTodo() async {
    final title = _textController.text.trim();
    if (title.isEmpty) return;

    final tempTodo = Todo(id: 0, title: title, completed: false);

    setState(() {
      todos.insert(0, tempTodo); //리스트맨위에 반영
      _textController.clear(); //입력초기화
    });
    try {
      await addTodoToService(title);
      loadTodos();
    } catch (e) {
      print("추가 오류: $e");
    }
  }

  ///////////////////////////////////////  delete
  void _deleteTodoConfirm(int id) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
          title: const Text("정말 삭제하시겠습니까? "),
          content: const Text("삭제하면 되돌릴수 없습니다"),
          actions: [
            TextButton(
              child: const Text("취소"),
              onPressed: () => Navigator.pop(context),
            ),
            TextButton(
              child: const Text("삭제"),
              onPressed: () async {
                Navigator.pop(context);
                try {
                  await deleteTodo(id); //서버에서 삭제요청
                  loadTodos(); //목록새로불러오기
                } catch (e) {
                  print("삭제 오류: $e");
                }
              },
            )
          ]),
    );
  }

  ///////////////////////////////////////
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        // 기본앱구조를제공 -Scaffold
        appBar: AppBar(title: Text('TODO 테스트')), //상단앱바, 페이지제목표시
        body: Column(//세로로 요소들을 배치
            children: [
          Expanded(
            //  남은공간 전부차지할께
            child: isLoading
                ? const Center(child: CircularProgressIndicator()) //로딩인디케이터
                : ListView.builder(
                    itemCount: todos.length,
                    itemBuilder: (context, index) {
                      final todo = todos[index];
                      return ListTile(
                          title: Text(todo.title),
                          trailing: Row(
                            mainAxisSize:
                                MainAxisSize.min, //Row크기를 자식들크기에 맞춰 최소화
                            children: [
                              Icon(
                                  todo.completed
                                      ? Icons.check_circle
                                      : Icons.radio_button_unchecked,
                                  color: todo.completed
                                      ? Colors.green
                                      : Colors.grey),
                              IconButton(
                                icon:
                                    const Icon(Icons.delete, color: Colors.red),
                                onPressed: () => _deleteTodoConfirm(todo.id),
                              )
                            ],
                          ));
                    },
                  ),
          ),
          Padding(
              padding: const EdgeInsets.all(8.0),
              child: Row(
                children: [
                  Expanded(
                      child: TextField(
                    controller: _textController,
                    decoration: const InputDecoration(hintText: '할일을 입력하세요'),
                  )),
                  ElevatedButton(onPressed: _addTodo, child: const Text('추가'))
                ],
              ))
        ]));
  }
}
/*
*/
