package com.company.java009;

//1. 클래스는 부품객체
//2. 클래스는 속성(멤버변수)과 행위(멤버함수)
class Animal002{
	//속성-멤버변수
	String name; int age;
	//행위-멤버함수
	void show() { System.out.println(this.name + "\t" + this.age);  }
}
public class Class002_Animal {
	public static void main(String[] args) {
		Animal002 a1 = new Animal002(); a1.name="sally";   a1.show();  
		//1. new(공간,객체생성) 2. Animal002() 초기화 3. a1 주소 = 1번지
		Animal002 a2 = new Animal002(); a2.name="alpha";   a2.show();  
		//1. new(공간,객체생성) 2. Animal002() 초기화 3. a2 주소 = 2번지
	}
}  //객체들- 인스턴스?  a1 , a2  -  this.name
/*
------------------------------------  [runtime data area]
[method:정보, static, final:공용정보]   Animal002(클래스-설계도) ,public Class002
-------------------------------------------------------
[heap:동적]     			 		|[stack:잠깐빌리기]
15번째줄: 2번지 {name=alpha,age=0}  ← a2 :2번지   this
13번째줄: 1번지 {name=sally,age=0}  ← a1 :1번지   this
					 	 		| main
-------------------------------------------------------
*/
