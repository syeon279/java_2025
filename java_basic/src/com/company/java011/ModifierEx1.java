package com.company.java011;

import com.company.java011_ex.Milk;

public class ModifierEx1 {

	public static void main(String[] args) {
		Milk m1 = new Milk();  
		System.out.println( m1 );  
		m1.setMprice(2000);       
		System.out.println( m1 );
		
	}

}
//연습문제1)  지정접근자
//패키지명 : com.company.java011_ex
//클래스명 : FinalEx
//다음과 같이 코드를 작성하시오.
//ㅁ출력된화면
//   Milk [mno=0, mname=null, mprice=0]
//   Milk [mno=0, mname=null, mprice=2000]
