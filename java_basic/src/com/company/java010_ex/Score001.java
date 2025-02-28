package com.company.java010_ex;
class Score {
	String name,p,s,rank; int kor, eng, math, total; double avg;
	
	void process() {
		//총점, 평균 계산
		total = this.kor + this.eng + this.math;
		avg = total/3f;
	}
	void pass() {
		// 합격 계산
		p = (avg<60)?"불합격":(kor<40 || eng<40|| math<40)? "재시험" : "합격";
	}
	void schola() {
		//장학생 계산
		s = (avg>95)? "장학생" : "---";
	}
	void star() {
		//평균 정도를 별로 표현
		for(int i=0; i<=avg/10;i++) {
			rank += "★";
		}
	}
	void show() {
		process(); pass(); schola(); star();
		System.out.println("------------------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
		System.out.println(this.name+this.kor+this.eng+this.math+this.total+String.format("%.2f", this.avg)+this.p+this.s+this.rank);
	}
}
public class Score001 {

	public static void main(String[] args) {
		Score iron = new Score();
		iron.name="IronMan";
		iron.kor=99;
		iron.eng=100;
		iron.math=100;
		iron.show();
	}

}
