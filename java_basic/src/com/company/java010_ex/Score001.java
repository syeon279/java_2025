package com.company.java010_ex;
class Score0011 {
	String name;
	String p,s,rank; int kor, eng, math, total; double avg;
	
	public void process() {
		total = this.kor + this.eng + this.math;
		avg = total/3f;
	}
	public void pass() {
		p = (avg<60)?"불합격":(kor<40 || eng<40|| math<40)? "재시험" : "합격";
	}
	public void schola() {
		s = (avg>95)? "장학생" : "---";
	}
	public void star() {
		for(int i=0; i<=avg/10;i++) {
			rank += "★";
		}
	}
	public void show() {
		process(); pass(); schola(); star();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
		System.out.println(this.name+"\t"+this.kor+"\t"+this.eng+"\t"+this.math+"\t"+this.total+"\t"+
		String.format("%.2f", this.avg)+"\t"+this.p+"\t"+this.s+"\t"+this.rank);
	}
}
public class Score001 {

	public static void main(String[] args) {
		Score0011 iron = new Score0011();
		iron.name="IronMan";
		iron.kor=99;
		iron.eng=100;
		iron.math=100;
		iron.show();
	}

}
