package com.company.java013;

class Score {
	private String name; 
	private int kor, eng, math, total;
	private double avg;
	public String getName() { return name; } 
	public void setName(String name) { this.name = name; }
	public int getKor() { return kor; } 
	public void setKor(int kor) { this.kor = kor; }
	public int getEng() { return eng; } 
	public void setEng(int eng) { this.eng = eng; }
	public int getMath() { return math; } 
	public void setMath(int math) { this.math = math; }
	public int getTotal() { return total; } 
	public void setTotal(int total) { this.total = total; }
	public double getAvg() { return avg; } 
	public void setAvg(double avg) { this.avg = avg; }
	
}
class ScoreDto extends Score{

	private String p, s, rank;
	public String getP() { return p; } public void setP(String p) { this.p = p; }
	public String getS() { return s; } public void setS(String s) { this.s = s; }
	public String getRank() { return rank; } public void setRank(String rank) { this.rank = rank; }
	
	public ScoreDto(String name, int kor, int eng, int math) {
		setName(name); setKor(kor); setEng(eng); setMath(math);
	}
}

abstract class Prcess{
	abstract double exec(int kor, int eng, int math);
	abstract double exec(int total);
	abstract String exec(double avg);
}

class Total extends Prcess {
	Total() {
	}
	@Override
	double exec(int kor, int eng, int math) {
		return 0;
	}
	@Override
	double exec(int total) {
		return total;
	}
	@Override
	String exec(double avg) {
		return String.format("%,2f", avg);
	}
	
}
class Avg extends Prcess{
	@Override
	double exec(int kor, int eng, int math) {
		return 0;
	}
	@Override
	double exec(int total) {
		return 0;
	}
	@Override
	String exec(double avg) {
		return String.format("%,2f", avg);
	}
}

class Pass extends Prcess{
	@Override
	double exec(int kor, int eng, int math) {
		return 0;
	}
	@Override
	double exec(int total) {
		return 0;
	}
	@Override
	String exec(double avg) {
		return null;
	}
	
}
class Jang extends Prcess{
	@Override
	double exec(int kor, int eng, int math) {
		return 0;
	}
	@Override
	double exec(int total) {
		return 0;
	}
	@Override
	String exec(double avg) {
		return null;
	}
	
}

class Star extends Prcess{
	@Override
	double exec(int kor, int eng, int math) {
		return 0;
	}
	@Override
	double exec(int total) {
		return 0;
	}
	@Override
	String exec(double avg) {
		return null;
	}
}


abstract class Print{
	abstract void show(ScoreDto std);
	abstract void show(ScoreDto [] std);
}

class StdPrint extends Print{
	@Override
	void show(ScoreDto std) {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격\t장학생\t랭킹");
		System.out.println(std.getName()+"\t"+std.getKor()+"\t"+std.getEng()+"\t"+std.getMath()+"\t"
		+std.getTotal()+"\t"+std.getAvg()+"\t"+std.getP()+"\t"+std.getS()+"\t"+std.getRank());
	}

	@Override
	void show(ScoreDto[] std) {
	}
	
}
////////
public class Abstract003 {
	public static void main(String[] args) {
		ScoreDto std = new ScoreDto("헐크", 100, 100, 99);
		Process process = null;
		Print print = null;
		print = new StdPrint(); print.show(std);
	}
}
