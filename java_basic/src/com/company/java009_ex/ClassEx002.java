package com.company.java009_ex;

import java.util.Scanner;

class MyPrice001{
  String name;  int price;
  void input() {
	  Scanner scanner = new Scanner(System.in);
	  System.out.print("상품 이름 입력> "); this.name = scanner.next();
	  System.out.print("상품 가격 입력> "); this.price = scanner.nextInt();
  }
  void show() { 
	  System.out.println("상품 정보입니다.");
	  System.out.println("상품이름: " + this.name +"  /  " + "상품 가격: " + this.price);
  }
}
public class ClassEx002 {

	public static void main(String[] args) {
		MyPrice001   p1 = new MyPrice001();
		p1.input();
		p1.show();
	}

}

//출력내용 : 
//  상품이름 입력 >  apple
//  상품가격 출력 >  1500
//
//  상품정보입니다
//  상품이름 : apple  / 상품가격 : 1500