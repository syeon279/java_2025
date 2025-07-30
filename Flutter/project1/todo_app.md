#### 1. Todo 개요
1. 백엔드 api 설계 및 구현 
2. flutter에서 api 연동 테스트 
3. flutter에서 ui 기본 구조 작성 - list, add, update, delete 

<br />
<br />
<br />

----

##### 1. 백엔드 api 설계 및 구현
1. spring boot 프로젝트 (jap, mysql, lobok, spring-dev , web)
   - pom.xml / build path
2. model - entity , repository
3. service
4. controller
5. rest api postman 테스트

##### 2. flutter에서 api 연동 테스트
■ 프로젝트 만들기
1. ctrl + shift + p
2. Flutter: New project 

■ 애뮬레이터 실행
1. ctrl + shift + p
2. Flutter: Launche Emulator

```
flutter devices
flutter run -d chrome
```


##### 3. flutter ui기본구조작성 - list, add, update, delete

###### 1. 구조확인
■ model/todo.dart
■ services/todo_service.dart
■ pages/todo_page.dart
■ main.dart

lib/
├── main.dart
├── models/
│   └── todo.dart
├── services/
│   └── todo_service.dart 
├── pages/
|   └── todo_page.dart

###### 2. http 패키지 추가
> pubspec.yaml

```yaml
dependencies :
   flutter:
      sdk: flutter
   http: ^0.13.6

```

2. 다운로드
```
flutter pub get
```

```dart
import 'package:http/http.dart' as http; //http 연결
import 'dart:convert'; // 인코딩 및 json 디코딩
import '../models/todo.dart'; //todo 모델클래스 

Future<List<Todo>> fectchToolds() async { // 비동기
  final response =
      await http.get(Uri.parse("http://192.168.40.177:8080/api/todos")); // 비동기 처리 

  if (response.statusCode == 200) {
    final decoded = utf8.decode(response.bodyBytes);
    List<dynamic> jsonData = json.decode(decoded);
    return jsonData.map((item) => Todo.fromJson(item)).toList(); //json 
  } else {
    throw Exception("API 호출 실해: ${response.statusCode}");
  }
}
```