package com.company.java016_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + "]";
	}
	
	
	
}

public class MapEx002 {

	public static void main(String[] args) {
		Map <Integer, UserInfo> map = new HashMap<>();
		map.put(1, new UserInfo("아이언맨", 50));
		map.put(2, new UserInfo("헐크", 40));
		map.put(3, new UserInfo("캡틴", 120));
		map.put(1, new UserInfo("아이언맨-new", 50));
		
		// int a = 1; 기초값 - 객체의 기능사용 불가
		// Integer e = 1; 객체 - 객체의 기능 사용 사능 = wrapper 클래스!
		
		Iterator <Entry <Integer, UserInfo>> users = map.entrySet().iterator();
		while(users.hasNext()) {
			Entry <Integer, UserInfo> user = users.next();
			System.out.println("사용자 정보: "+user.getValue().getName()+" / "+user.getValue().getAge());
			
		}
		
	} //E main

} // E class
//연습문제2)  Collection  Framework
//패키지명 : com.company.java016_ex
//클래스명 : MapEx002
//Q1. HashMap만들기
//Q2. 아래데이터 넣기
//map.put(  1,  new UserInfo("아이언맨"    , 50) );  // 1 넣어도 Integer( 클래스, 객체 )
//map.put(  2,  new UserInfo("헐크"       , 40) );  // wrapper 클래스
//map.put(  3,  new UserInfo("캡틴"       , 120) ); // boxing
//map.put(  1,  new UserInfo("아이언맨-new", 50) ); 
//
//Q3. Iterator로 출력하기 - 사용자정보