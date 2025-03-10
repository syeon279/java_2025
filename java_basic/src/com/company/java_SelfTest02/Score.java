package com.company.java_SelfTest02;

public class Score {
	private String name;
	private int kor,eng,math;
	private double avg;
	private String pass;
	
	
	public String getName() { return name; } 
	public void setName(String name) { this.name = name; }
	public int getKor() { return kor; } 
	public void setKor(int kor) { this.kor = kor; }
	public int getEng() { return eng; } 
	public void setEng(int eng) { this.eng = eng; }
	public int getMath() { return math; } 
	public void setMath(int math) { this.math = math; }
	public double getAvg() { return avg; } 
	public void setAvg(double avg) { this.avg = avg; } 
	public String getPass() { return pass; } 
	public void setPass(String pass) { this.pass = pass; }
	
	public Score() {
		super();
	}
	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public Score(String name, int kor, int eng, int math, double avg, String pass) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.avg = avg;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", avg=" + avg + ", pass="
				+ pass + "]";
	}
}// E class

class ScoreProcess extends Score {
	public void process_avg(Score[] std) {
		for(int i=0; i<std.length;i++) {
			std[i].setAvg((std[i].getKor()+std[i].getEng()+std[i].getMath())/3.0);
		}
	}

	public void process_pass(Score[] std) {
		for(int i =0; i<std.length;i++) {
			std[i].setPass( std[i].getAvg() >= 60? "합격" : "불합격");
		}
	}
	
}//E class

class ScorePrint extends Score {
	
	public void show(Score[] std) {
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t국어\t영어\t수학\t평균\t합격여부");
		for(Score s : std )
		System.out.println(s.getName()+"\t"+s.getKor()+"\t"+s.getEng()
							+ "\t" + s.getMath() + "\t" + String.format("%.2f", s.getAvg())
							+"\t"+s.getPass());
	}
}// E class
