package com.company.java009_ex;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx007 {
	
	public static void who_are_you(String [][] users){
		Scanner scanner = new Scanner(System.in);
		System.out.print("아이디를 입력해주세요> "); String tempId  = scanner.next();
		String result = "유저를 확인해주세요.";	
//		switch (tempId) {
//		case "aaa" : result = tempId+"는 " + users[0][2]+" 사람 입니다."; break;
//		case "bbb" : result = tempId+"는 " + users[1][2]+" 사람 입니다."; break;
//		case "ccc" : result = tempId+"는 " + users[2][2]+" 사람 입니다."; break;
//		}
//		System.out.println(result); 
		
		for (int i=0;i<users.length;i++) {
			if(tempId.equals(users[i][0])) {
				result = users[i][0]+"는 " + users[i][2]+" 사람 입니다."; 
			}
		}
		System.out.println(result); 
			
	} // 아이디가 맞을 때 까지 반복??
	
	public static void who_pass_change(String [][] users){
		Scanner scanner = new Scanner(System.in);
		String tempId[]  = new String [1];
		String tempPw[]  = new String [1];
		System.out.print("아이디를 입력해주세요> "); tempId[0] = scanner.next();
		System.out.print("비밀번호를 입력해주세요> "); tempPw[0] = scanner.next();
		String result = "다시 확인해주세요.";
		switch(tempId[0]) {
		case "aaa" : 
			if (!(users[0][1].equals(tempPw[0]))){
			System.out.println(result); break;
			} else {
				System.out.println("변경하실 비밀번호를 입력하세요> "); String sPw = scanner.next(); 
				users[0][1] = sPw; 
				System.out.println("정보확인: " + Arrays.deepToString(users[0])); break;
			}
		case "bbb" :
			if (!(users[1][1].equals(tempPw[0]))){
				System.out.println(result); break;
				} else {
					System.out.println("변경하실 비밀번호를 입력하세요> "); String sPw = scanner.next(); 
					users[1][1] = sPw; 
					System.out.println("정보확인: " + Arrays.deepToString(users[1]));break;
				}
		case "ccc" : 
			if (!(users[2][1].equals(tempPw[0]))){
				System.out.println(result); break;
				} else {
					System.out.println("변경하실 비밀번호를 입력하세요> "); String sPw = scanner.next(); 
					users[2][1] = sPw; 
					System.out.println("정보확인: " + Arrays.deepToString(users[2]));break;
				}
		}
		
	}
	public static void main(String[] args) {

	   String [][] users = {{"aaa", "111", "한국"} ,     // 00 01 02
	                      { "bbb", "222", "호주"} ,       // 10 11 12
	                      { "ccc", "333", "중국"}};      // 20 21 22

	   who_are_you(users);    
	   who_pass_change(users); 
	}

}//E class
//연습문제6)  method
//패키지명 : com.company.java008_ex
//클래스명 :  MethodEx006
//
//public class MethodEx006{ 

//   who_pass_change(users); 
//   //  public static void who_pass_change(String [][] users){ 아이디,비밀번호가 맞으면 비밀번호 바꾸기}
//}
//
//
//출력내용) who_are_you(users);    
//아이디를 입력해주세요>aaa
//aaa는 한국사람입니다.
//
//
//출력내용)
//who_pass_change(users); 
////  public static void who_pass_change(String [][] users){ 아이디,비밀번호가 맞으면 비밀번호 바꾸기}
//
//아이디를 입력해 주세요 > bbb
//비밀번호를 입력해 주세요 > 123
//유저를 확인해주세요!
//
//아이디를 입력해 주세요 > bbb
//비밀번호를 입력해 주세요 > 222
//변경하실 비밀번호를 입력해주세요123
//정보확인 : [bbb, 123, 호주]