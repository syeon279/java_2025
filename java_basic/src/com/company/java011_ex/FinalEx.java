package com.company.java011_ex;
//1. 클래스는 부품객체
//2.final 수정하지마 

/*
 * 초기화 순서:      기본값 -> 명시적 초기화 -> 초기화 블록 -> 생성자
 * final nation    null     korea         korea(x)    korea(x)
 * final jumin     null     null(x)       null(x)     "00000"(o)
 *       name      null     null(x)       null(x)     .연산자이용, 수정가능
 */
class User002 {

  @Override
	public String toString() {
		return "User002 [nation=" + nation + ", jumin=" + jumin + ", name=" + name + "]";
	}
  final String nation = "Korea";   
  final String jumin;   
  String name;

  public User002() { this.jumin = "00000"; }
  public User002(String jumin, String name) {
     this.jumin = jumin;
     this.name = name;
  }
  
}
public class FinalEx {
	public static void main(String[] args) {
		User002 user1 = new User002("123456-1234567", "아이유");
		System.out.println(user1);   
		
//		 user1.nation = "USA";      //  cannot be assigned final로 고정했기 때문에
//	     user1.jumin  = "123123-1234321"; // cannot be assigned
	     user1.name = "IU"; 
	     System.out.println(user1);   

	}
}
/*
-------------------------------------
[method:정보]   User002.class   , FinalEx.class , final{nation, jumin}  //##1
-------------------------------------
[heap]                       | [stack]
1번지 : {nation, jumin,name }
                             |  main  //##2
-------------------------------------
 */
