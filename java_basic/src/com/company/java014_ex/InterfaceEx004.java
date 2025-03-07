package com.company.java014_ex;

import java.util.Arrays;
import java.util.Calendar;

interface Launch {
	int MONEY = 10000;
	void eat();
}
class Burger implements Launch{
	int price;
	public Burger () {
		this.price = 3900;
	}
	@Override
	public void eat() {
		System.out.println("Burger 냠냠!");
	}
	@Override
	public String toString() {
		return "Burger";
	}
}
class KimchiStew implements Launch {
	int price;
	public KimchiStew() {
		this.price = 4000;
	}
	@Override
	public void eat() {
		System.out.println("KimchiStew 냠냠!");
	}
	@Override
	public String toString() {
		return "KimchiStew";
	}
}
class User {
	int money; int cnt;
	Launch [] plate;
	User(){
		money = Launch.MONEY; 
		plate = new Launch[3];
		cnt = 0;
	}
	void order(Launch launch) {
		//1. 주문한 메뉴의 값 확인
		int temp = 0;
		if(launch instanceof Burger) {
			System.out.println(launch.toString()+" 하나요~!");
			temp = ((Burger)launch).price; // 왜???
		} else if (launch instanceof KimchiStew) {
			System.out.println(launch.toString()+" 하나요~!");
			temp = ((KimchiStew)launch).price;
		}
		//2. 내가 가진 돈 확인
		if(money<temp) {
			System.out.println("잔액이 부족하여 주문이 불가능합니다."); return;
		}
		money -= temp;
		//3. plate 에 주문 받은거 넣기
		//plate에다가 주문한 걸 어떻게 담지???
		plate[cnt++] = launch;
//		System.out.println(money + "-" + Arrays.toString(plate));
		}
	void show() {
		String order = "주문  :";
//		for(int i =0; i<plate.length;i++) {
//			if(plate[i]!=null) {
//				order += ((i!= 0)? ", ": "  ")+plate[i];
//			}
//		}
		for(int i = 0; i<cnt; i++) {
			order += ((i!= 0)? ", ": "  ")+plate[i];
		}
		System.out.println(order);
//		System.out.println("주문   : "+ Arrays.toString(plate) );
		System.out.println("주문 금액 : "+ (Launch.MONEY-money) );
		System.out.println("잔액 : "+ money);
//		for(Launch l : plate) {
//			l.eat();
//		}
		
		Calendar today = Calendar.getInstance();
		System.out.println(today.get(1)+"년 "+
					(today.get(2)+1)+"월 "+
						today.get(5)+"일 ");
		for(int i = 0; i<cnt; i++) {
			plate[i].eat();
		}
//		for(int i =0; i<plate.length;i++) {
//			if(plate[i]!=null) {
//				plate[i].eat();
//			}
//		}
	}
//	@Override
//	public String toString() {
//		return "User [plate=" + Arrays.toString(plate) + "]";
//	}
}

public class InterfaceEx004 {

	public static void main(String[] args) {
		User launchorder = new User();
		launchorder.order(new Burger());
		launchorder.order(new KimchiStew());
		launchorder.order(new Burger());
		launchorder.show();
	}

}

