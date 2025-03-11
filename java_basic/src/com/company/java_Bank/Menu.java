package com.company.java_Bank;

import java.util.Scanner;

class Menu {
	Bank[] users;
	public void exec() {
		System.out.println("======BANK======\r\n"
				+ "*1. 추가\r\n"
				+ "*2. 조회\r\n"
				+ "*3. 입금\r\n"
				+ "*4. 출금\r\n"
				+ "*5. 삭제\r\n"
				+ "*9. 종료\r\n"
				);

	Scanner scanner = new Scanner(System.in);
	String result = " 다시 입력해주세요. ";
	
	while(true) {
		System.out.println("입력 : "); 
		int choice = scanner.nextInt();
		if(choice == 9) {
			System.out.println("종료합니다."); 
			break;
		}
		if(!(choice>0 && choice<6)) {
			System.out.println(result); 
			continue;
		}
		switch(choice){
		case 1: new Input().exec(users); break;
		case 2: new Show().exec(users); break;
		case 3: new Deposit().exec(users); break;
		case 4: new Withdraw().exec(users); break;
		case 5: new Delete().exec(users);
		}
	}
	}
} // E class