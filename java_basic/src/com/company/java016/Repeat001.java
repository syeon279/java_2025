package com.company.java016;

import java.util.ArrayList;
import java.util.List;

//Q1.   다음 빈칸을 채우시오
//1. 콜렉션프레임워크
//- [  배열   ]의 단점을 개선한 클래스 [ 객체 ]만 저장가능   ( 동적배열 )
//- 저장공간의 크기를 [ 동적 ]으로 관리함.
//
//2. 핵심 인터페이스 [ List, Set, Map   ]
//- 인터페이스를 통해서 틀이 잡혀 있는 방법으로 
//다양한 컬렉션 클래스를 이용함.
//
//List : ##5.   기차      인덱스여부 [ o ] ,  중복허용여부 [ o ] ,  [ add, get(index), size, remove, contain ] 
//Set  : ##6.   주머니   인덱스여부  [ x ] ,  중복허용여부  [ x ]  ,   [ add, 향상된 for문/Iterator, remove, contain ] 
//Map  : ##7.   사전      [ key, value ] - 쌍(Entry),        [ put, get(key), size, remove, contain ] 
//

class UserInfo{
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public UserInfo() {
		super();
	}
	public UserInfo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + "]";
	}
	
}

public class Repeat001 {
	public static void main(String[] args) {
		List<UserInfo> users = new ArrayList<>();
		users.add(new UserInfo("아이언맨" , 50));
		users.add(new UserInfo("헐크" , 40));
		users.add(new UserInfo("캡틴" , 120));
	
	for(int i=0; i<users.size(); i++) {
		System.out.println(users.get(i).getName()+"/"+users.get(i).getAge());
	}
	
	for(UserInfo u : users) {
		System.out.println(u);
		System.out.println(u.getName() + " / " + u.getAge());
	}

	}// E main
}// E class


//Q2.  ArrayList, HashSet 을 작성하시오.
//1. UserInfo    Dto 클래스만들기    - 속성 :  private  String name; private  int age;
//2. users ArrayList 만들기
//3. 다음의 데이터 넣기
//   new UserInfo("아이언맨" , 50) , new UserInfo("헐크" , 40) , new UserInfo("캡틴" , 120)
//4. for+size / 향상된 for 이용해서 데이터 출력
