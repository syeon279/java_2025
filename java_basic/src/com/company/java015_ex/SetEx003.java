package com.company.java015_ex;

import java.util.HashSet;
import java.util.Set;

public class SetEx003 {

	public static void main(String[] args) {
		
		Set<Integer>lotto = new HashSet<>();
//		for(int i =1; i<46;i++) {
//			lotto.add(i);
//		}
		
		System.out.println("1. 랜덤 : 0 ~ 0.99999 > " + Math.random() ); // (int)(Math.random()*45(원하는 개수)+1)
		System.out.println("2. * 45 : 0*45 ~ 0.999999*45 > " + Math.random()*45 );
		System.out.println("3. 소숫점 떼기    > " + (int)(Math.random()*45));
		System.out.println("4. +1  >   "+(int)(Math.random()*45+1));

		//lotto.add((int)(Math.random()*45+1));
		
		
		while(lotto.size()<6) { //6개보다 작다면 계속 추가
			lotto.add((int)(Math.random()*45+1));
		}
		System.out.println(lotto);
	} // E main

} // E class
//연습문제3)  Collection  Framework
//패키지명 : com.company.java015_ex
//클래스명 : SetEx003
//- 중복되는 숫자없이  랜덤으로 숫자6개를 받는 로또를 만들려고 한다.
//1. 알맞은 콜렉션프레임워크는?
//2. 프로그램을 작성하시오.