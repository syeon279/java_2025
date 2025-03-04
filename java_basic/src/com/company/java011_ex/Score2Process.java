package com.company.java011_ex;

public class Score2Process {

	public void process_avg(Score2[] std) { //주소 따라가서 데이터 수정하겠습니다.
		//System.out.println("process_avg 주소 확인: "+System.identityHashCode(std));
		// std[0].avg =std[0].kor + std[0].eng + std[0].math/3.0
		// std[0].setAvg( std[0].getKor + std[0].getEng + std[0].getMath/3.0;);
		for(int i=0;i<std.length;i++) {
			std[i].setAvg( (std[i].getKor() + std[i].getEng() + std[i].getMath())/3.0);
		}
	}

	public void process_pass(Score2[] std) {
		//System.out.println("process_pass 주소 확인: "+System.identityHashCode(std));
		//60이상 합격
		for(int i =0; i<std.length;i++) {
			std[i].setPass( std[i].getAvg() >= 60? "합격" : "불합격");
		}
	}

}
