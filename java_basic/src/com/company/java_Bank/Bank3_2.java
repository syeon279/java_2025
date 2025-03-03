package com.company.java_Bank;

import java.util.ArrayList;
import java.util.Scanner;

class User {
	// 유저 추가, 조회, 삭제
	String[] id = new String[5]; String[] pw = new String [5]; 
	int[] balance= new int[5]; int [] age = new int[5];
	static Scanner scanner = new Scanner(System.in);
	
	public User() { }
	public User(String id, String pw, int age, int balance) {
		this.id = id; this.pw = pw; this.age = age; this.balance = balance;
	}
	void addUser() {
		for(int i=0;i<id.length;i++) {
			if(id[i] == null) {
				System.out.println("===1. 계좌 추가===");
				System.out.print("ID 입력: "); id[i] = scanner.next();
				System.out.print("비밀번호 입력: "); pw[i] = scanner.next();
				System.out.print("나이 입력: "); age[i] = scanner.nextInt();
				System.out.print("잔액 입력: "); int amount = scanner.nextInt();
				if(amount<0) {
					System.out.println("유효하지 않은 금액입니다.");
				} else {balance[i] = amount;}
			} else {
				System.out.println("더 이상 회원가입은 불가능합니다.");
			}
		} 
	}// E addUser
	public void userInfo() {
		System.out.println("===2. 계좌 조회===");
		if(userCheck() != -1) {
			System.out.println("Id: " + id[userCheck()]);
			System.out.println("Password: " + pw[userCheck()]);
			System.out.println("나이: " + age[userCheck()]);
			System.out.println("잔액: " + balance[userCheck()]); 
		}
	}// E userInfo
	public void deposit() {
		System.out.println("===3. 입금==="); 
		if(userCheck() != -1) {
			System.out.print("입금 금액: ");int amount = scanner.nextInt();
			if(amount<0) {
				System.out.println("유효하지 않은 금액입니다.");
			} else {
				System.out.println("==입금 완료==");
				System.out.println("잔액: " + (balance[userCheck()]+=amount)); 
			}
		}
	}//E deposit
	public void withdrawal() {
		System.out.println("===4.출금==="); 
		if(userCheck()!=- 1) {
			System.out.print("출금 금액: "); int amount = scanner.nextInt();
			if((balance[userCheck()]-amount)<0) {
				System.out.println("출금 금액이 잔액보다 크면 출금이 불가능합니다.");
				System.out.println("현재 잔액: " + balance[userCheck()]);
			} else {
				System.out.println("===출금 완료===");
				System.out.println("잔액: " + (balance[userCheck()]-=amount)); 
			}
		}
	}// E withdrawal
	void deleteAccount() {
		if(userCheck()!=-1) {
			System.out.println("계좌를 삭제하시겠습니까? (Y/N)"); char delacnt = scanner.next().charAt(0);
			if (delacnt == 'y' || delacnt == 'Y') {
				id[userCheck()] = null; pw[userCheck()]= null; 
				age[userCheck()] = 0; balance[userCheck()]=0;
				System.out.println("계좌가 삭제되었습니다."); 
			} else {
				System.out.println("계좌 삭제가 취소되었습니다.");
			}
		}
	} // E deletAccount
	public int userCheck() {
		String tempId, tempPw; 
		System.out.print("ID 입력: "); tempId = scanner.next();
		System.out.print("비밀번호 입력: ");  tempPw = scanner.next();
		int result=-1;
		for(int i=0; i<id.length; i++) {
			if(tempId.equals(id[i]) && tempPw.equals(pw[i])){
				result = i;
			}
		}return result;
	}
}// E userCheck
/////////////////////
public class Bank3_2 {
	static Scanner scanner = new Scanner(System.in);
//	static ArrayList<User> users = new ArrayList<>();
	

	public static void main(String[] args) {
		String menu = "======BANK======\n1.추가\n2.조회\n3.입금\n4.출금\n5.삭제\n9.종료";
		int choice; 
		String wrongUser = "계좌가 없거나 잘못된 사용자 정보입니다.";
		
		while (true) {
			System.out.println(menu);
			System.out.print("입력>  "); choice = scanner.nextInt();
			if (choice == 9) {
				System.out.println("종료 기능입니다."); break;
			}
			if ( (choice<0) || (choice>5)) {
				System.out.println("다시 확인해 주세요."); continue;
			} //E choice
			
			switch (choice) {
			case 1 : 
				new User();
				addUser(); break;
			case 2 :
				 if () {
                     System.out.println(wrongUser);  
                 } else {
                     userInfo(); 
                 }
				 break;
			case 3 : 
				if () {
                 System.out.println(wrongUser); 
				} else {
                  deposit(); 
				}
				break;
			case 4 :
				if () {
					System.out.println(wrongUser);
				} else {
					withdrawal();
				}
				break;
			case 5 :
				if () {
                System.out.println(wrongUser); 
				} else {
                deleteAccount();
//                null; 
				}
			}
		}
	}

	}// E main

}// E class
