package com.company.java011_ex;

import com.company.java011_ex.Apple;

public class ClassArrEx001 {

	public static void main(String[] args) {
		Apple[] apples= new Apple[3]; 
		
		apples[0] = new Apple();
		apples[0].setName("RED"); apples[0].setOrder("iron"); apples[0].setNum(2); apples[0].setPrice(1000);
		apples[1] = new Apple();
		apples[1].setName("GREEN"); apples[1].setOrder("hurk"); apples[1].setNum(1); apples[1].setPrice(1500);
		apples[2] = new Apple();
		apples[2].setName("GOLD"); apples[2].setOrder("captain"); apples[2].setNum(3); apples[2].setPrice(2000);
		
		System.out.println(apples[0]);
		System.out.println(apples[1]);
		System.out.println(apples[2]);
		
		//향상된 for문
		// for( 해당자료형 one : 배열   ) {}
		System.out.println("====for");
		for(Apple one:  apples) {
			System.out.println(one);
		}
	}

}
//연습문제1)  클래스배열
//패키지명 : com.company.java011_ex
//클래스명 : ClassArrEx1
//다음과 같이 코드를 작성하시오.
//ㅁ출력된 화면
//Apple [name=RED, order=iron, num=2, price=1000]
//Apple [name=GREEN, order=hulk, num=1, price=1500]
//Apple [name=GOLD, order=captain, num=3, price=2000]

//public class ClassArrEx1{
//  public static void main(String[] args) {
//        Apple[] apples= new Apple[3]; 
//        //위의 화면처럼 값 셋팅
//        //위의 화면처럼 출력
//  }
//}
