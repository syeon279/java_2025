package com.company.java_Bank;

import java.util.Scanner;

import com.company.java_Bank.Bank;
import com.company.java_Bank.Bank4_Controller;

class Bank{
	private String id;
	private String pass;
	private double balance;
	static String Company = "(주)회사";
	int find=-1;
	String result = " ";
	
	public String getId() { return id; } public void setId(String id) { this.id = id; }
	public String getPass() { return pass; } public void setPass(String pass) { this.pass = pass; }
	public double getBalance() { return balance; } public void setBalance(double balance) { this.balance = balance; }
	
	public Bank() {
		super();
	}
	public Bank(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	}
	
	public void userCheck(Bank[] users) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ID : "); String tempId = scanner.next();
		System.out.println("Password : "); String tempPass = scanner.next();
		
		for(int i=0; i<users.length; i++) {
			if((users[i]!=null) && (users[i].getId().contentEquals(tempId) && users[i].getPass().contentEquals(tempPass))) {
				find = i;
				result = "사용자 정보가 확인되었습니다.";
			} else {
				result = "계좌 정보가 존재하지 않습니다.";
			}
		}
		System.out.println(result);
	}
} // E class

interface Bank4_Controller {
	void exec(Bank[] users);
}

class Input extends Bank implements Bank4_Controller { 
	@Override
	public void exec(Bank[] users) {
		for(int i=0; i<users.length;i++) {
			if(users[i]==null) {
				Scanner scanner = new Scanner(System.in);
				Bank user = new Bank();
				System.out.print("ID 입력: "); 
				//		String tempId = scanner.next();
				user.setId(scanner.next());
				System.out.print("비밀번호 입력: ");
				//        String temPass = scanner.next();
				user.setPass(scanner.next());
				System.out.print("잔액 입력: "); 
				int tempBalance = scanner.nextInt();
				if(tempBalance<0) {
					result = "유효하지 않은 금액입니다."; 
				} else {
					user.setBalance(tempBalance); 
					result = "사용자 정보가 저장되었습니다.";
					break;
				}
			}
		}// E for
		System.out.println(result);
	}
	
} // E class

class Show extends Bank implements Bank4_Controller {
	@Override
	public void exec(Bank[] users) {
		userCheck(users);
		if(find!=-1) {
			System.out.println("===2. 계좌 조회===");
			System.out.println("Id: " + users[find].getId());
			System.out.println("Password: " + users[find].getPass());
			System.out.println("잔액: " + users[find].getBalance()); 
		}
	}
	
}// E class

class Deposit extends Bank implements Bank4_Controller {
	@Override
	public void exec(Bank[] users) {
		userCheck(users);
		if(find!=-1) {
			System.out.println("입금 :"); Scanner scanner = null;
			users[find].setBalance(users[find].getBalance() + scanner.nextInt());
			System.out.println("==입금 완료");
			System.out.println("잔액: " + users[find].getBalance()); 
		}
	}
	
}// E class

class Withdraw extends Bank implements Bank4_Controller {
	@Override
	public void exec(Bank[] users) {
		userCheck(users);
		if(find!=-1) {
			System.out.println("===4.출금==="); 
			System.out.print("출금 금액: "); Scanner scanner = null;
			int amount = scanner.nextInt();
			if((users[find].getBalance()-amount)<0) {
				System.out.println("출금 금액이 잔액보다 크면 출금이 불가능합니다.");
				System.out.println("현재 잔액: " + users[find].getBalance());
			} else {
				System.out.println("===출금 완료===");
				users[find].setBalance((users[find].getBalance()-amount));
				System.out.println("잔액: " + users[find].getBalance() ); 
			}
		}
	}
}// E class

class Delete extends Bank implements Bank4_Controller {
	@Override
	public void exec(Bank[] users) {
		userCheck(users);
		if(find!=-1) {
			System.out.println("계좌를 삭제하시겠습니까? (Y/N)"); Scanner scanner = null;
			char delacnt = scanner.next().charAt(0);
			if (delacnt == 'y' || delacnt == 'Y') {
				users[find].setId(null); users[find].setPass(null); users[find].setBalance(0);
				System.out.println("계좌가 삭제되었습니다.");  
			} else { System.out.println("계좌 삭제가 취소되었습니다."); }
		}
	}
	
}// E class
