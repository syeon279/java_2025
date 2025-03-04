package com.company.java011_ex;

//1. 클래스는 부품객체 / 상태와 행위
//2. 상태-멤버 변수(클래스 변수, 인스턴스 변수, 지역변수)
class Sawon3{ 
  int        pay =10000;    //클래스 변수가 아니라 인스턴스 변수. heap - new 랑 관련이 있음. this, 생성자
  static int su=10;     //클래스 변수 method - new x - 공유
   
  static int basicpay=pay;  //클래스 변수 , | 클래스 변수 = 인스턴스 변수 (클래스 변수, 클래서 메서는 this, 인스턴스 변수 사용 불가)
   
  static int basicpay2;     //클래스 변수 | 0으로 초기화
  
//3. 행위-멤버 함수(클래스 함수, 인스턴스 함수)
  public static void showSu() { // 클래스 메서드 - method - new x - 공유
	  System.out.println(su);  
  }          
  public static void showPay() { // 클래스 메서드
	  System.out.println(this.pay);  //스태틱에서는 this 사용 불가능 
  }    

  public  void  showAll001() {   //클래스 메서드가 아닌 인스턴스 함수 heap - new O - this, 생성자
     System.out.println(su);  
     System.out.println(this.pay);  
  } 
  public static  void  showAll002() {   //클래스 함수 - method - new x - 공유
      showAll001();    // 스태틱이 아님. 인스턴스 사용 불가 - heap - new O - this, 생성자
     System.out.println(this.pay); //스태틱에서는 this 사용 불가능
  } 
} //E class
public class MemberVarEx001 {

	public static void main(String[] args) { //args 지역변수
	   Sawon3   sola = new Sawon3();  // sola 지역변수 
	   sola.showAll001(); // 인스턴스 메서드
	  }

	}

//-- class Sawon3작성해주세요 
//1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
//2. 인스턴스메서드, 클래스메서드 구분하시오.
//3. 오류나는 이유는?

