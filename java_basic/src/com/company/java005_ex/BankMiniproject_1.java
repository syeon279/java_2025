package com.company.java005_ex;

import java.util.Scanner;

public class BankMiniproject_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		int acnt = 0; int age = 0; int sel;
		String id = " "; String pw = " ";
		String menu = "======BANK======\n1.추가\n2.조회\n3.입금\n4.출금\n5.삭제\n9.종료";
//		System.out.println(menu);
//		System.out.print("입력>  "); sel = scanner.nextInt();
//		System.out.print("ID > "); id = scanner.next().charAt(0);
//		System.out.print("Password > "); pw = scanner.next().charAt(0);
		
		for (;;) {
			System.out.println(menu);
			System.out.print("입력>  "); sel = scanner.nextInt();
			if (sel == 9) {
				System.out.println("종료 기능입니다."); break;
			}
			if ((sel<=0) || (sel>=10)) {
				System.out.println("다시 확인해 주세요.");
			} 
			switch (sel) {
				case 1 : 
					System.out.println("추가기능입니다.");
					System.out.print("ID > "); id = scanner.next();
					System.out.print("Password > "); pw = scanner.next();
					System.out.println("나이 입력 >"); age = scanner.nextInt();
					System.out.println("잔액 입력 >"); acnt += scanner.nextInt(); 
					break; // E case1
				case 2 :
					//System.out.println("조회기능입니다.");
					System.out.print("ID > "); String tempId = scanner.next();
					System.out.print("Password > "); String tempPw = scanner.next();
					if ( id.equals(tempId) && pw.equals(tempPw)) {
						System.out.println("==계좌 조회");
						System.out.println("나이: " + age);
						System.out.println("잔액: " + acnt); 						
					} else {
						System.out.println("없는 계좌입니다. 다시 확인해 주세요.");
					}
					break; // E case2
				case 3 :
					//System.out.println("입금기능입니다.");
					System.out.print("ID > "); tempId = scanner.next();
					System.out.print("Password > "); tempPw = scanner.next();
					if ( id.equals(tempId) && pw.equals(tempPw)) {
					System.out.println("입금 :"); acnt += scanner.nextInt();
					System.out.println("==입금 완료");
					System.out.println("잔액: " + acnt); 
					} else {
						System.out.println("다시 확인해 주세요.");
					}
					break; // E case3
				case 4 :
					//System.out.println("출금기능입니다.");
					System.out.print("ID > "); tempId = scanner.next();
					System.out.print("Password > "); tempPw = scanner.next();
					if ( id.equals(tempId) && pw.equals(tempPw)) {
					System.out.println("출금 : "); acnt -= scanner.nextInt();
					System.out.println("==출금 완료");
					System.out.println("잔액: " + acnt); 
					} else {
						System.out.println("다시 확인해 주세요.");
					}
					break; // E case4
				case 5 :
					//System.out.println("삭제기능입니다.");
					System.out.print("ID > "); tempId = scanner.next();
					System.out.print("Password > "); tempPw = scanner.next();
					if ( id.equals(tempId) && pw.equals(tempPw)) {
						System.out.println("계좌를 삭제하시겠습니까? (Y/N)"); char delacnt = scanner.next().charAt(0);
						if (delacnt == 'y' || delacnt == 'Y') {
							id = " "; pw= " ";
							System.out.println("계좌가 삭제되었습니다."); 
							break; //E case5
						} 
					} else {
						System.out.println("다시 확인해 주세요.");
					}
				}// E switch
		}// E for
	}// e main
		
}// 

// 1. 케이스 234 일 때 
//System.out.print("ID > "); tempId = scanner.next();
//System.out.print("Password > "); tempPw = scanner.next();
//if ( id.equals(tempId) && pw.equals(tempPw)) {
// 줄이기
// 2.  마이너스 통장 안되게 

