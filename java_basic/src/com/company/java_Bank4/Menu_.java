package com.company.java_Bank4;

//import java.util.ArrayList;
import java.util.Scanner;

class Menu {
	Bank[] users;
//	ArrayList<Bank> user = new ArrayList<>();
	
	Bank4_Controller controller;
	Bank4_Controller [] process;
	
	public Menu() {
		users = new Bank[3];
		process = new Bank4_Controller [] {
				new Input(), new Show(), new Deposit(), new Withdraw(), new Delete()  
		};
	}
	public void exec() {
		
		Scanner scanner = new Scanner(System.in);
		String result = " 다시 입력해주세요. ";
		
		while(true) {
			System.out.println("======BANK======\r\n"
					+ "*1. 추가\r\n"
					+ "*2. 조회\r\n"
					+ "*3. 입금\r\n"
					+ "*4. 출금\r\n"
					+ "*5. 삭제\r\n"
					+ "*9. 종료\r\n"
					);
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

			controller = process[choice-1]; controller.exec(users); 
//			switch(choice){ 
//				case 2: controller = process[choice-1];controller.exec(users); break;
//				case 3: controller = process[2];controller.exec(users);break;
//				case 4: controller = process[3];controller.exec(users);break;
//				case 5: controller = process[4];controller.exec(users);
//			}
		}
	}
} // E class