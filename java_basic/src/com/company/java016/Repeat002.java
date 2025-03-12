package com.company.java016;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class UserInfo2{
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
	
	
	public UserInfo2() {
		super();
	}
	public UserInfo2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "회원 정보 [name=" + name + ", age=" + age + "]";
	}
}

public class Repeat002 {
	public static void main(String[] args) {
		Set<UserInfo2>users = new HashSet<>();
		users.add(new UserInfo2("아이언맨" , 50));
		users.add(new UserInfo2("헐크" , 40));
		users.add(new UserInfo2("캡틴" , 120));
		
		Iterator<UserInfo2> userIter = users.iterator();
		while(userIter.hasNext()) {
			UserInfo2 temp = userIter.next();
			System.out.println(temp);
		}
		
		for(UserInfo2 u : users) {
			System.out.println(u);
		}
		
	}

}
//5. sets  HashSet 만들기
//6. 다음의 데이터 넣기
//   new UserInfo("아이언맨" , 50) , new UserInfo("헐크" , 40) , new UserInfo("캡틴" , 120)
//7. for+size / 향상된 for 이용해서 데이터 출력