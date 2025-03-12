package com.company.java_Bank4_final;

import java.util.Scanner;

class Bank{
	private String id;
	private String pass;
	private double balance;

	public String getId() { return id; } 
	public void setId(String id) { this.id = id; }
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
	@Override
	public String toString() {
		return "Bank [id=" + id + ", pass=" + pass + ", balance=" + balance + "]";
	} 
	
} // E class

interface Bank4_Controller {
	void exec(Bank[] users);
}

class UserCheck {
	public int exec(Bank[] users) {
		Scanner scanner = new Scanner(System.in);
		int find=-1;  String result = "계좌 정보가 존재하지 않습니다.";
		System.out.println("ID : "); String tempId = scanner.next();
		System.out.println("Password : "); String tempPass = scanner.next();
		
		for(int i=0; i<users.length; i++) {
			if(users[i]!=null  &&  users[i].getId().equals(tempId) && users[i].getPass().equals(tempPass)){
				find = i; break;
			} 
		}
		if(find!=-1) { result="계좌정보가 확인되었습니다.";}
		System.out.println(result);
		return find;
	}
}
class Input  implements Bank4_Controller { 
	@Override
	public void exec(Bank[] users) {
		String result="";
		Scanner scanner = new Scanner(System.in);
		int find = -1;
		//처리1-빈칸검사
		for(int i=0; i<users.length;i++) { 
			if(users[i] == null) { find=i; break; }
		} 
		if(find==-1) { System.out.println("더이상 회원 가입을 받지 않습니다."); return;}
		
		
		//처리2-입력받기
		users[find] = new Bank(); //인스턴스 생성
		System.out.print("ID 입력: "); 
		users[find].setId(scanner.next());
		System.out.print("비밀번호 입력: ");
		users[find].setPass(scanner.next());
		System.out.print("잔액 입력: "); 
		int tempBalance = scanner.nextInt();
		if(tempBalance<0) {
			result = "유효하지 않은 금액입니다."; 
		} else {
			users[find].setBalance(tempBalance); 
			result = "사용자 정보가 저장되었습니다."; 
		}
		
		System.out.println(result);
	}
} // E class

class Show  implements Bank4_Controller {
	@Override
	public void exec(Bank[] users) {
		int find=-1;
		find = new UserCheck().exec(users);
		if(find!=-1) {
			System.out.println("===2. 계좌 조회===");
			System.out.println("Id: " + users[find].getId());
			System.out.println("Password: " + users[find].getPass());
			System.out.println("잔액: " + users[find].getBalance()); 
		}
	}
}// E class

class Deposit  implements Bank4_Controller {
	@Override
	public void exec(Bank[] users) {
		int find= new UserCheck().exec(users);
		if(find!=-1) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("입금 :"); int amount = scanner.nextInt();
			if(amount<0) {
				System.out.println("유효하지 않은 금액입니다.");
			} else {
			users[find].setBalance(users[find].getBalance() + amount);
			System.out.println("==입금 완료");
			System.out.println("잔액: " + users[find].getBalance()); 
			}
		}
	}
}// E class

class Withdraw  implements Bank4_Controller {
	@Override
	public void exec(Bank[] users) {
		int find= new UserCheck().exec(users);
		if(find!=-1) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("===4.출금==="); 
			System.out.print("출금 금액: "); 
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

class Delete  implements Bank4_Controller {
	@Override
	public void exec(Bank[] users) {
		int find= new UserCheck().exec(users);
		if(find!=-1) { 
			System.out.println("계좌를 삭제하시겠습니까? (Y/N)"); 
			Scanner scanner = new Scanner(System.in);
			char delacnt = scanner.next().charAt(0);
			if (delacnt == 'y' || delacnt == 'Y') {
				users[find]=null;
				System.out.println("계좌가 삭제되었습니다.");  
			} else { System.out.println("계좌 삭제가 취소되었습니다."); }
		}
	}
}// E class
