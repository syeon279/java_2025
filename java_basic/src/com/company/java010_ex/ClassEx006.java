package com.company.java010_ex;
class Score {
	String stdid; int kor,eng,math,total; double avg;  
	void total() {
		total = kor + eng + math;
	}
	void avg() {
		avg = total/3.0;
	}
	void info() {
		total();
		avg();//메서드 안에서 메서드 호출
		System.out.println("학번\t kor\teng\tmath\ttotal\tavg");
		System.out.println(stdid +"  "+ kor+"\t" + eng+"\t" + math+"\t" + total+"\t" + String.format("%.2f", avg));
	}
	public Score() {
	}
	public Score(String stdid, int kor, int eng, int math) {
		this.stdid = stdid; this.kor = kor; this.eng = eng; this.math = math;
	}
}
public class ClassEx006 {

	public static void main(String[] args) {
		Score  s1= new Score("std1234" , 100, 100 , 99 ); 
	    s1.info();
	}

}
//연습문제4)  class
//패키지명 : com.company.java010_ex
//클래스명 :  ClassEx006
//-- 생성자 작성하시오.

//public class ClassEx005{
//   public static void main(String[] args) {
//   Score  s1= new Score("std1234" , 100, 100 , 99 ); 
//   s1.info();
//   }
//}
//
//출력내용 :
//학번   kor   eng   math   total   avg
//std1234   100   100   99   299   99.67