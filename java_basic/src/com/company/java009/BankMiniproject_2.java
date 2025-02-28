package com.company.java009;

import java.util.Scanner;

public class BankMiniproject_2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); 
		int[] acnt = new int[3]; int[] age = new int[3]; int sel; int acntOut = 0, acntIn=0;
		String[] id = new String[3]; String[] pw = new String[3]; 
		boolean found = false;
		boolean wrongPassword = false;
		String menu = "======BANK======\n1.추가\n2.조회\n3.입금\n4.출금\n5.삭제\n9.종료";
		
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
					if(id[i]==null) {
						System.out.print("ID > "); 
						id[i]=scanner.next(); 
						System.out.print("Password > "); 
						pw[i]=scanner.next(); 
						System.out.println("나이 입력 >"); 
						age[i]=scanner.nextInt(); 
						System.out.println("잔액 입력 >"); acntIn = scanner.nextInt();
						if (acntIn>0) {
							acnt[i] = acntIn; 
						} else {
							System.out.println("이 통장은 마이너스 통장이 아닙니다. 다시 확인해 주세요."); 
						}
						break;
					}//E if
				}// E for
				found = true;
			} else {
				System.out.print("ID > "); String tempId[] = new String[1]; tempId[0] = scanner.next();
				System.out.print("Password > "); String tempPw[] = new String[1]; tempPw[0] = scanner.next();
				for(int i =0; i<id.length;i++) { // 아이디가 있는지 배열을 반복해서 확인
					if (id[i] != null && id[i].equals(tempId[0])) { // 아이디가 널값이 아니면 비교
						found = true; // "없는 계좌 안내문"을 출력X
							if(pw[i].equals(tempPw[0])) {  //비밀번호가 일치?
								wrongPassword = false;
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
										id[i] = null; pw[i]= null; age[i] = 0; acnt[i]=0;
										System.out.println("계좌가 삭제되었습니다."); 
										found = false;
									} else {
									System.out.println("계좌 삭제가 취소되었습니다.");
									}
									break; // E case 5
								}// E switch
							}  else {
								wrongPassword = true;
								break;
							}
						} //E id != null
					
				}// E for:id 확인
				
			} // E sel 2,3,4,5
			
			if (!found) {
				System.out.println("없는 계좌입니다. 다시 확인하세요.");
			} else if (wrongPassword) {
				System.out.println("잘못된 비밀번호 입니다.");
			}
		}// E for
		
	}// E main
		
}// E class
