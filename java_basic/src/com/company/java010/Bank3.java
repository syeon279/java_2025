package com.company.java010;

import java.util.Scanner;

class User {
	// 유저 추가, 조회, 삭제
	String id, pw; int balance=0, age;
	static Scanner scanner = new Scanner(System.in);
	
	public User() {
		id = null; pw = null; age = 0; balance = 0;
	}
	public User(String id, String pw, int age, int balance) {
		this.id = id; this.pw = pw; this.age = age; this.balance = balance;
	}
	void addUser() {
		System.out.println("===1. 계좌 추가===");
		System.out.print("ID 입력: "); id = scanner.next();
        System.out.print("비밀번호 입력: "); pw = scanner.next();
        System.out.print("나이 입력: "); age = scanner.nextInt();
        System.out.print("잔액 입력: "); 
        if(balance<0) {
        	System.out.println("유효하지 않은 금액입니다.");
        } else {
        	balance = scanner.nextInt();
        }
	}
	public void userInfo() {
		System.out.println("===2. 계좌 조회===");
		System.out.println("Id: " + id);
		System.out.println("Password: " + pw);
		System.out.println("나이: " + age);
		System.out.println("잔액: " + balance); 
	}
	public void deposit() {
		System.out.println("===3. 입금==="); 
		System.out.print("입금 금액: ");int amount = scanner.nextInt();
		if(amount<0) {
			System.out.println("유효하지 않은 금액입니다.");
		} else {
			System.out.println("==입금 완료==");
			System.out.println("잔액: " + (balance+=amount)); 
		}
	}
	public void withdrawal() {
		System.out.println("===4.출금==="); 
		System.out.print("출금 금액: "); int amount = scanner.nextInt();
		if((balance-amount)<0) {
			System.out.println("출금 금액이 잔액보다 크면 출금이 불가능합니다.");
			System.out.println("현재 잔액: " + balance);
		} else {
			System.out.println("===출금 완료===");
			System.out.println("잔액: " + (balance-=amount)); 
		}
	}
	void deleteAccount() {
		System.out.println("계좌를 삭제하시겠습니까? (Y/N)"); char delacnt = scanner.next().charAt(0);
		if (delacnt == 'y' || delacnt == 'Y') {
			id = null; pw= null; age = 0; balance=0;
			System.out.println("계좌가 삭제되었습니다."); 
		} else {
		System.out.println("계좌 삭제가 취소되었습니다.");
		}
	}
	public boolean userCheck() {
		String tempId, tempPw; 
		System.out.print("ID 입력: "); tempId = scanner.next();
		System.out.print("비밀번호 입력: ");  tempPw = scanner.next();
		return tempId.equals(id) && tempPw.equals(pw);
	}
}
/////////////////////
public class Bank3 {
	static Scanner scanner = new Scanner(System.in);
//	static ArrayList<User> users = new ArrayList<>();
	static User u1 = null;

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
				u1 = new User();
				u1.addUser(); break;
			case 2 :
				 if (!u1.userCheck() || u1 == null ) {
                     System.out.println(wrongUser);  
                 } else {
                     u1.userInfo(); 
                 }
				 break;
			case 3 : 
				if (!u1.userCheck() || u1 == null) {
                 System.out.println(wrongUser); 
				} else {
					
                 u1.deposit(); 
				}
				break;
			case 4 :
				if (!u1.userCheck()|| u1 == null) {
					System.out.println(wrongUser);
				} else {
					u1.withdrawal();
				}
				break;
			case 5 :
				if (!u1.userCheck()|| u1 == null) {
                System.out.println(wrongUser); 
				} else {
                u1.deleteAccount();
                u1 = null; 
				}
			}
		}// 메뉴 무한반복하기 
	}// E main

}// E class
