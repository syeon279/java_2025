package com.company.java011_ex;

public class Score {
////멤버변수////////////////////////////////////////////////////////////////
///변수가 private 라면 getters/setters 사용하기 
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getKor() { return kor; }
	public void setKor(int kor) { this.kor = kor; }
	public int getEng() { return eng; }
	public void setEng(int eng) { this.eng = eng; }
	public int getMath() { return math; }
	public void setMath(int math) { this.math = math; }
	
	private String name;
	private int kor, eng, math , total;
	private double aver;
	private String p  , s  , rank="";
//멤버 함수/////////////////////////////////////////////////////////////////
	public Score() { }
	public Score(String name, int kor, int eng, int math) {
		this.name=name; this.kor=kor; this.eng=eng; this.math=math; // 사용자들에게 입력받은 다음에 
	}
	public static void Info() {
		line();
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
		line();
	}
	void preshow() {
		total=kor+eng+math;
		aver = (kor+eng+math)/3.0;
		if(aver>=60) { p="합격";} 
			else { p="불합격"; }
		if (aver>=90) { s="장학생"; } 
			else { s="---"; }
		for(int i =0;i<(int)(aver/10);i++) { rank += "★"; }
	}
	public void show() {
		preshow();
		System.out.println(name +"\t"+ kor+"\t" + eng+"\t" + math+"\t" +total+"\t"+ String.format("%.2f", aver)+"\t" + p+"\t" + s+"\t" + rank);
	}
	static void line() {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	}
	
}
