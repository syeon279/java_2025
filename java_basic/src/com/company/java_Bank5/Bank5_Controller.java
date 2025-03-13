package com.company.java_Bank5;

import java.util.ArrayList;
import java.util.Scanner;

interface Bank5_Controller {
	void exec(ArrayList<Bank> users);
}

class UserCheck {
	public int check(ArrayList<Bank> users) {
		Scanner scanner = new Scanner(System.in);
		int find=-1;  String result = "계좌 정보가 존재하지 않습니다.";
		System.out.println("ID : "); String tempId = scanner.next();
		System.out.println("Password : "); String tempPass = scanner.next();
		
		for(int i=0; i<users.size(); i++) {
			Bank user = users.get(i);
			if(users.get(i)!=null  &&  user.getId().equals(tempId) && user.getPass().equals(tempPass)){
				find = i; break;
			} 
		}
		if(find!=-1) { result="계좌정보가 확인되었습니다.";}
		System.out.println(result);
		return find;
		
	}

}// E class
class Input  implements Bank5_Controller { 
	@Override
	public void exec(ArrayList<Bank> users) {
		String result="";
		Scanner scanner = new Scanner(System.in);
		//입력받기 
		System.out.print("ID 입력: "); String tempId = scanner.next();
		System.out.print("비밀번호 입력: "); String tempPass = scanner.next();
		System.out.print("잔액 입력: "); int tempBalance = scanner.nextInt();
		if(tempBalance<0) {
			result = "유효하지 않은 금액입니다."; return;
		} else {
			result = "사용자 정보가 저장되었습니다."; 
		}
		users.add(new Bank(tempId, tempPass, tempBalance));
		System.out.println(result);
	}
} // E class

class Show  implements Bank5_Controller {
	@Override
	public void exec(ArrayList<Bank> users) {
		int find=-1;
		find = new UserCheck().check(users);
		if(find!=-1) {
			System.out.println("===2. 계좌 조회===");
			System.out.println("Id: " + users.get(find).getId());
			System.out.println("Password: " + users.get(find).getPass());
			System.out.println("잔액: " + users.get(find).getBalance() ); 
		}
	}
}// E class

class Deposit  implements Bank5_Controller {
	@Override
	public void exec(ArrayList<Bank> users) {
		int find= new UserCheck().check(users);
		if(find!=-1) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("입금 :"); int amount = scanner.nextInt();
			if(amount<0) {
				System.out.println("유효하지 않은 금액입니다.");
			} else {
			users.get(find).setBalance(users.get(find).getBalance() + amount);
			System.out.println("==입금 완료");
			System.out.println("잔액: " + users.get(find).getBalance()); 
			}
		}
	}
}// E class

class Withdraw  implements Bank5_Controller {
	@Override
	public void exec(ArrayList<Bank> users) {
		int find= new UserCheck().check(users);
		if(find!=-1) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("===4.출금==="); 
			System.out.print("출금 금액: "); 
			int amount = scanner.nextInt();
			if((users.get(find).getBalance()-amount)<0) {
				System.out.println("출금 금액이 잔액보다 크면 출금이 불가능합니다.");
				System.out.println("현재 잔액: " + users.get(find).getBalance());
			} else {
				System.out.println("===출금 완료===");
				users.get(find).setBalance((users.get(find).getBalance()-amount));
				System.out.println("잔액: " + users.get(find).getBalance() ); 
			}
		}
	}
}// E class

class Delete  implements Bank5_Controller {
	@Override
	public void exec(ArrayList<Bank> users) {
		int find= new UserCheck().check(users);
		if(find!=-1) { 
			System.out.println("계좌를 삭제하시겠습니까? (Y/N)"); 
			Scanner scanner = new Scanner(System.in);
			char delacnt = scanner.next().charAt(0);
			if (delacnt == 'y' || delacnt == 'Y') {
				users.remove(find);
				System.out.println("계좌가 삭제되었습니다.");  
			} else { System.out.println("계좌 삭제가 취소되었습니다."); }
		}
	}
}// E class
