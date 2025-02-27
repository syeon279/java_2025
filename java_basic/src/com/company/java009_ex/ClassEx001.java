package com.company.java009_ex;
class Student001{
	String name; int no, kor, eng, math;
	int total = kor + eng + math; float avg = total/3.0f;
	void info() {
		int total = this.kor + this.eng + this.math; float avg = total/3.0f;
		System.out.println("이름: "+ this.name);
		System.out.println("학번: "+ this.no);
		System.out.println("총점: "+ total);
		System.out.println("총점: "+ this.total); //초기값이 0 이기때문에 
		System.out.println("평균: "+ String.format("%.2f", avg));
		System.out.println("평균: "+ String.format("%.2f", this.avg)); //초기값이 0 이기 때문에 
	};
}
public class ClassEx001 {

	public static void main(String[] args) {
		 Student001 s1 = new Student001();
	     s1.name="first";  s1.no=11; s1.kor=100; s1.eng=100; s1.math=99;
	     s1.info();
	}

}
//클래스는 설계도 인스턴스화 (Heap이라는 공간에 new를 통해 객체생성)를 통해 - 객체(객체들 s1, s2 등 뭉쳐서 표현) / 인스턴스(각각의 s1.name , s1.kor 등 ) 
//-----------------------------------  [runtime data area] 실행되는 화면? 
//[method:정보, static, final:공용정보]		Students001.class	/	ClassEx001.class
//--------------------------------------------------------------------------------------
//[heap:동적]                            |[stack:잠깐빌리기]		
//19 번째 줄: 1번지 {name="first" 등}		←   s1 : 1번지
//18 번째 줄:  1번지 {name 등}	            ←   s1 : 1번지
//				                        |  main
//--------------------------------------------------------------------------------------

//출력내용 : 
//  이름: first
//  총점 : 299
//  평균 : 99.67