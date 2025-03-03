package com.company.java010;

import java.util.Scanner;

public class Bank2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); 
		int sel; int acntOut = 0, acntIn=0;
		String[] id = new String[3];   // 
		String[] pw = new String[3]; 
		int[] acnt = new int[3]; 
		int[] age  = new int[3]; 
 
		
		String menu = "======BANK======\n1.추가\n2.조회\n3.입금\n4.출금\n5.삭제\n9.종료";
		
		for (;;) {
			System.out.println(menu);
			System.out.print("입력>  "); sel = scanner.nextInt();
			if (sel == 9) {
				System.out.println("종료 기능입니다."); break;
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
						if (acntIn>0) { acnt[i] = acntIn; }
						else { System.out.println("이 통장은 마이너스 통장이 아닙니다. 다시 확인해 주세요."); }
						break;
					}//E if
				}// E for
			} else {
				//////////////////// 사용자인증.
				System.out.print("ID > "); 
				String tempId =  scanner.next();
				System.out.print("Password > "); 
				String tempPw = scanner.next();
				int found = -1;
				for(int i =0; i<id.length;i++) { // 아이디가 있는지 배열을 반복해서 확인
					if (id[i] != null && id[i].equals(tempId)  && pw[i].equals(tempPw)  ) { // 아이디가 널값이 아니면 비교
						found = i; break; // "없는 계좌 안내문"을 출력X
					}
				}

				//////////////////// 해당번호로 계좌처리
				if (found==-1) {
					System.out.println("없는 계좌입니다. 다시 확인하세요.");
					continue;
				}  
								
				switch (sel) {
				case 2 :
					System.out.println("==계좌 조회");
					System.out.println("Id: " + id[found]);
					System.out.println("Password: " + pw[found]);
					System.out.println("나이: " + age[found]);
					System.out.println("잔액: " + acnt[found]); 						
					break; // E case2
				case 3 :
					System.out.println("입금 :"); acnt[found] += scanner.nextInt();
					System.out.println("==입금 완료");
					System.out.println("잔액: " + acnt[found]); 
					break; // E case3
				case 4 :
					System.out.println("출금 : "); acntOut = scanner.nextInt();
					if ((acnt[found]-acntOut)<0) {
						System.out.println("출금 금액이 잔액보다 크면 출금이 불가능합니다.");
						System.out.println("잔액: " + acnt[found]);
					} else {
						System.out.println("==출금 완료"); acnt[found] -= acntOut;
						System.out.println("잔액: " + acnt[found]); 						
					}
					break; // E case4
				case 5 :
					System.out.println("계좌를 삭제하시겠습니까? (Y/N)"); char delacnt = scanner.next().charAt(0);
					if (delacnt == 'y' || delacnt == 'Y') {
						id[found] = null; pw[found]= null; age[found] = 0; acnt[found]=0;
						System.out.println("계좌가 삭제되었습니다.");  
					} else { System.out.println("계좌 삭제가 취소되었습니다."); }
					break; // E case 5
				}// E switch
							 
					
				}// E for:id 확인
				 
			
		}// E for 
	}// E main
		
}// E class
