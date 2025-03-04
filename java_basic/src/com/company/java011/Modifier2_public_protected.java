package com.company.java011;
import com.company.java011_ex.Cat;

class Cat2 extends Cat{ // Cat2:java011, Cat: java011_ex
	public void show() {
		public_=10;
		protected_=20; // extends 사용 가능
		//package_=30; // 같은 폴더에서 사용가능
		//privated_=40;  //Cat 클래스에서만 사용 - getter/setter
		System.out.println(public_+"/"+protected_);
	}
}

public class Modifier2_public_protected {
	public static void main(String[] args) {
		Cat2 cat2 = new Cat2();
		cat2.show();
		
		cat2.public_=100; // 아무데서나 접근가능 
		//cat2.protected_=200; // extends 에서만 사용 extends Cat
	}

}
/*
-------------------------------------
[method:정보]   
-------------------------------------
[heap]                       | [stack]
1번지 : { }
                         	 |  main  //##2
-------------------------------------
 */