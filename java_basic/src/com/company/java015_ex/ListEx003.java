package com.company.java015_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserInfo {
	private String name;
	private  int age;
	
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

public class ListEx003 {
	public static void main(String[] args) {
		List<UserInfo> users = new ArrayList<>();
		
		users.add(new UserInfo("아이언맨", 50));
		users.add(new UserInfo("헐크" , 40));
		users.add(new UserInfo("캡틴" , 120));
		
		
		for(UserInfo user : users) {
			System.out.println(user.getName()+", "+ user.getAge()); 
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("유저의 이름을 입력하세요: "); String tempName = scanner.next();
		for(int i = 0; i<users.size();i++) {
			if(tempName.equals((users.get(i)).getName())){
				UserInfo temp = users.get(i);
//				System.out.println(temp.getName()+", "+temp.getAge()); break;
				System.out.println(temp);
			}
		}
		
	}// E main

}// E class


//2. users ArrayList 만들기
//3. 다음의 데이터 넣기
//   new UserInfo("아이언맨" , 50) , new UserInfo("헐크" , 40) , new UserInfo("캡틴" , 120)
//4. for+size / 향상된 for 이용해서 데이터 출력
//5. 사용자들의 이름 입력받기 - 이름을 입력받으면 해당하는  유저의 자료출력
//
//> 원하는 유저의 이름을 입력하세요    _예) 아이언맨
//"아이언맨" , 50