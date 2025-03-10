package com.company.java015_ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class UserInfo02{
	private int no; private  String name; private  int age;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
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
	
	public UserInfo02() {
		super();
	}

	public UserInfo02(int no, String name, int age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserInfo [no=" + no + ", name=" + name + ", age=" + age + "]";
	}
	
	// 중복 불허 1) hashCode 2) equals 3) 
	@Override
	public int hashCode() {
		return Objects.hash(no, name, age); // 객체 기반 생성 확인
	}
	@Override
	public boolean equals(Object obj) { // 객체 안의 값이 같은지 확인
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo02 other = (UserInfo02) obj;
		return age == other.age && Objects.equals(name, other.name) && no == other.no;
	}
	
}

public class SetEx002 {

	public static void main(String[] args) {
		Set<UserInfo02> users = new HashSet<>();
		users.add(new UserInfo02(1, "아이언맨" , 50));
		users.add(new UserInfo02(2, "헐크" , 40));
		users.add(new UserInfo02(3, "캡틴" , 120));
		users.add(new UserInfo02(3, "캡틴" , 120));
		
		System.out.println("회원 수 : " + users.size());
		
		for(UserInfo02 user : users) {
			System.out.println(user);
		}
		System.out.println(":::::::::::::::::::::::::::::::");
		Iterator <UserInfo02> iter = users.iterator();
		iter = users.iterator();
		while(iter.hasNext()) {
			UserInfo02 temp = iter.next();
				System.out.println(temp);
		}
		///////////////////////////////
		System.out.println(users.getClass());
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름 입력> "); String tempName = scanner.next();
		// set에서 데이터 꺼내와 / 해당 데이터의 이름과 입력한 값이 같다면 / 해당 유저의 자료 출력
		iter = users.iterator(); // 모으기 iter -> [
		while(iter.hasNext()) { //  처리 대상 확인 iter[-> 
			UserInfo02 temp = iter.next(); // 꺼내기
			if(temp.getName().contains(tempName)) {
				System.out.println(temp);
			}
		}
		
	} // E main
} // E class

