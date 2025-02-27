package com.company.java009;

import java.util.Scanner;

public class BankMiniproject_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		int[] acnt = new int[3]; int[] age = new int[3]; int sel; int acntOut = 0, acntIn=0;
		String[] id = new String[3]; String[] pw = new String[3];
		String menu = "======BANK======\n1.추가\n2.조회\n3.입금\n4.출금\n5.삭제\n9.종료";
//		System.out.println(menu);
//		System.out.print("입력>  "); sel = scanner.nextInt();
//		System.out.print("ID > "); id = scanner.next().charAt(0);
//		System.out.print("Password > "); pw = scanner.next().charAt(0);
		
		for (;;) {
			System.out.println(menu);
			System.out.print("입력>  "); sel = scanner.nextInt();
			if (sel == 9) {
				System.out.println("종료 기능입니다."); continue;
			}
			if ( (sel<0) || (sel>5)) {
				System.out.println("다시 확인해 주세요."); continue;
			} //E !sel
			
			if (sel == 1 ) {
				System.out.println("추가기능입니다.");
				for(int i =0; i<id.length;i++) {
					for(int j =0; j<id.length;j++) {
						System.out.print("ID > "); 
						if(id[j].equals(null)) {
							id[j]=scanner.next(); break;
						}
					}
					for(int j=0; j<pw.length;j++) {
						System.out.print("Password > "); 
						if(pw[j].equals(null)) {
							pw[j]=scanner.next(); break;
						}
					}
					for(int j=0; j<age.length;j++) {
						System.out.println("나이 입력 >"); 
						if(age[j]==0) {
							age[j]=scanner.nextInt(); break;
						}
					}
					for(int j = 0; j<acnt.length;j++) {
						System.out.println("잔액 입력 >"); 
						if(acnt[j]==0) {
							if (acntIn>0) {
								acnt[j] += acntIn;
							} else {
								System.out.println("이 통장은 마이너스 통장이 아닙니다. 다시 확인해 주세요.");
							}
							acnt[j]=scanner.nextInt(); break;
						}
					}
				}// E for
			} else {
				System.out.print("ID > "); String tempId[] = new String[1]; tempId[0] = scanner.next();
				System.out.print("Password > "); String tempPw[] = new String[1];tempPw[0] = scanner.next();
				for(int i =0; i<id.length;i++) {
					if (id[i].equals(tempId[0]) && pw[i].equals(tempPw[0])) {
						switch (sel) {
						case 2 :
							System.out.println("==계좌 조회");
							System.out.println("Id: " + id[i]);
							System.out.println("Password: " + pw[i]);
							System.out.println("나이: " + age[i]);
							System.out.println("잔액: " + acnt[i]); 						
							break; // E case2
						case 3 :
							System.out.println("입금 :"); acnt[i] += scanner.nextInt();
							System.out.println("==입금 완료");
							System.out.println("잔액: " + acnt[i]); 
							break; // E case3
						case 4 :
							System.out.println("출금 : "); acntOut = scanner.nextInt();
							if ((acnt[i]-acntOut)<0) {
								System.out.println("출금 금액이 잔액보다 크면 출금이 불가능합니다.");
								System.out.println("잔액: " + acnt[i]);
							} else {
								System.out.println("==출금 완료"); acnt[i] -= acntOut;
								System.out.println("잔액: " + acnt[i]); 						
							}
							break; // E case4
						case 5 :
							System.out.println("계좌를 삭제하시겠습니까? (Y/N)"); char delacnt = scanner.next().charAt(0);
							if (delacnt == 'y' || delacnt == 'Y') {
								id[i] = " "; pw[i]= " ";
								System.out.println("계좌가 삭제되었습니다."); 
							} else {
							System.out.println("다시 확인해 주세요.");
							}
							break; // E case 5
						}// E switch
					} else {
						System.out.println("없는 계좌입니다. 다시 확인해 주세요.");
					} 
				}// E for
			} // E sel 2,3,4,5
			
		}// E for
		
	}// E main
		
}// E class

// 1. 케이스 234 일 때 
//System.out.print("ID > "); tempId = scanner.next();
//System.out.print("Password > "); tempPw = scanner.next();
//if ( id.equals(tempId) && pw.equals(tempPw)) {
// 줄이기
// 2.  마이너스 통장 안되게 

