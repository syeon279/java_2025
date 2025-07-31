class Todo {
  // 1. table + entity 매칭
  final int id;
  final String title;
  final bool completed;

  //required 반드시 필요함.
  Todo({required this.id, required this.title, required this.completed});

  factory Todo.fromJson(Map<String, dynamic> json) {
    //json 데이터를 Dart 객체로 변환해주는 팩토리 생성자
    return Todo(
        id: json['id'], title: json['title'], completed: json['completed']);
  }

  ////////
  Map<String, dynamic> toJson() {
    return {
      'title': title,
      'completed': completed,
    };
  }
}
//192.168.40.177
