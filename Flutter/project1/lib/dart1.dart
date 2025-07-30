// # 🌈 STEP 1. 다트 언어 완전 정복

// ## ✅ 실행 방법

// - **방법 1:** 아래 코드를 Dart 파일(`basic1.dart`)로 저장
// - **방법 2:** VS Code에서 직접 실행하거나 아래 명령어 입력
//   bash
//   dart lib/dart1.dart
//
//   > ⚠ 이건 Flutter UI가 없는 Dart 콘솔 실행입니다

// ---
// ## 🧸 예제 1: 내 이름과 나이 말해보기
// 📌 예제 포인트: 이름은 글자(String), 나이는 숫자(int)
// 📤 출력 예시:
// 안녕하세요, 사장님! 당신은 5살입니다.

// void main() {
//   String name = "단이";
//   int age = 5;

//   print('안녕하세요 $name님! 당신은 $age살입니다.');
// }

// 📖 예제 설명:
// 변수 `name`과 `age`를 선언하고, 문자열 안에 `$변수명`으로 값 넣기 연습!

// void main() {
//   String name = "소현";
//   int age = 26;
//   print('$name === $age');
// }

// ---
// ## 🎨 예제 2: 좋아하는 색과 점수
// 📌 예제 포인트: 리스트(List)와 맵(Map) 구조 익히기
// 📤 출력 예시:
// 첫 번째 색은 빨강!
// 영희는 90점이에요!

// void main() {
//   List<String> colors = ["green", "red", "blue"];
//   Map<String, int> scores = {'김영광': 95, '마동석': 100};
//   colors.add("gold"); //add get size remove
//   print('$colors');
//   colors.remove("red");
//   print('$colors');
//   print('첫번째 색은 ${colors[0]} ');
//   print('김영광의 점수는 ${scores['김영광']!} ');
// }

// 📖 예제 설명:
// `List`는 순서가 있고, `Map`은 이름-값 형태로 데이터를 저장합니다.

// ---
// ## 🧮 예제 3: 숫자놀이 – 홀수 짝수
// 📌 예제 포인트: 나머지 연산자 `%`와 조건문 `if`
// 📤 출력 예시:
// 0는 짝수!
// 1는 홀수!
// 2는 짝수!
// 📖 예제 설명:
// `%` 연산자는 숫자를 나눈 뒤 나머지를 구해요. `if` 조건으로 짝/홀수 판별할 수 있어요.

// void main() {
//   for (int i = 0; i < 3; i++) {
//     if (i % 2 == 0) {
//       print('$i는 짝수');
//     } else {
//       print('$i는 홀수');
//     }
//   }
// }

// ---
// ## 🧠 예제 4: 더하기 마법사 함수!
// 📌 예제 포인트: 함수 정의와 호출
// 📤 출력 예시:
// 3과 4를 더하면 7!
// 📖 예제 설명:
// `add` 함수는 두 수를 받아 더한 결과를 리턴해줘요. 화살표 `=>` 문법도 익혀봐요.

//리턴값 메서드명(파라미터){}
// int add(int a, int b) => a + b;
// void main() {
//   print('4와 10을 더하면 ${add(4, 10)}');
// }

// ---
// ## 💥 예제 5: 깜짝 에러 방지하기
// 📌 예제 포인트: try-catch로 예외 처리하기
// 📤 출력 예시:
// 앗! 문제가 생겼어요: IntegerDivisionByZeroException
// 100/3 -> 33.3333333....  //        100~/3 -> 33
// void main() {
//   try {
//     int result = 100 ~/ 0;
//   } catch (e) {
//     print("error............... $e");
//   }
// }

// 📖 예제 설명:
// 숫자를 0으로 나누면 에러가 나요. `try-catch` 문으로 안전하게 감싸줍니다!

// ---
// ## 🐶 예제 6: 동물 친구 클래스 만들기
// 📌 예제 포인트: 클래스 선언과 객체 만들기

class Animal {
  String name;
  Animal(this.name);
  void speak() {
    print('$name가 소리를 냅니다.');
  }
}

// void main() {
//   Animal puppy = Animal('강아지');
//   puppy.speak();
// }

// 📤 출력 예시:
// 강아지가 소리를 냅니다!

// 📖 예제 설명:
// 클래스는 틀이고, `Animal` 객체를 만들어 `speak()`로 행동하게 해볼 수 있어요.

// ---
// ## 🕒 예제 7: 잠깐 기다리는 비동기 마법
// 📌 예제 포인트: `async`/`await`로 비동기 처리

// 📤 출력 예시:
// 과자 기다리는 중...
// 맛있는 과자 가져왔어요!

// 📖 예제 설명:
// `await`는 기다렸다가 결과를 받는 키워드! 미래의 값을 다룰 때 꼭 필요해요.

Future<String> fetchSnack() async {
  // 비동기로 실행되어 미래에 String 값 return
  await Future.delayed(Duration(seconds: 3));
  return "맛있는 과자가 왔어요~!";
}

// void main() async {
//   print('과자 기다리는 중...');
//   String snack = await fetchSnack();
//   print(snack);
// }

// ---
// ## 📦 예제 8: 친구 정보 묶어주기 (레코드)
// 📌 예제 포인트: 여러 값을 한 번에 반환하는 구조 - 튜플: 바뀌지 않는 순서의 리스트
(String, int) getFrirendsInfo() {
  return ('사장님', 31);
}

void main() {
  var (name, age) = getFrirendsInfo();
  print('$name은 $age살이에요!');
}

// 📤 출력 예시:
// 유치원생은 6살이에요!

// 📖 예제 설명:
// Dart의 레코드(record) 문법으로 두 개 이상의 값을 한번에 return하고 받아올 수 있어요.







