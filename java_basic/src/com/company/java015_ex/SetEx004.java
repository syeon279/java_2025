package com.company.java015_ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

class Score {
	String name;
	int kor;
	int eng;
	int math;
	
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

	@Override
	public int hashCode() {
		return Objects.hash(eng, kor, math, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return eng == other.eng && kor == other.kor && math == other.math && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
	
}
public class SetEx004 {

	public static void main(String[] args) {
		Set <Score> scores = new HashSet<>();
		scores.add(new  Score("아이언맨",30,40,50)); 
		scores.add(new  Score("아이언맨",30,40,50)); 
		scores.add(new  Score("아이언맨",30,40,50)); 
		scores.add(new Score("헐크",40,60,70)); 
		scores.add(new  Score("캡틴",80,90,100));
		
		
		System.out.println("학생 수: "+scores.size());
		
		Iterator<Score> iter = scores.iterator();
		while(iter.hasNext()) {
			Score temp = iter.next();
			int total = temp.kor + temp.eng + temp.math;
			double avg = total/3.0;
			System.out.println(temp.name +"\t" + temp.kor+"\t" + temp.eng+"\t" + temp.math
					+"\t"+ total +"\t" + String.format("%.2f", avg));
		}
//		for(Score s : scores) {
//			System.out.println("학생 정보: " + s);
//			System.out.println("총점: " + (s.kor+s.eng+s.math));
//			System.out.println("평균: " + String.format("%.2f",(s.kor+s.eng+s.math)/3.0));
//			System.out.println("======================");
//		}
	} // E main

} // E class
//연습문제3)  Collection  Framework
//패키지명 : com.company.java015_ex
//클래스명 : SetEx004
//1. HashSet 만들기  
//2. 아래데이터 넣기
//scores.add(new  Score("아이언맨",30,40,50)); 
//scores.add(new  Score("아이언맨",30,40,50)); 
//scores.add(new  Score("아이언맨",30,40,50)); 
//scores.add(new Score("헐크"   ,40,60,70)); 
//scores.add(new  Score("캡틴",80,90,100));
//> 갯수는 3개로 나오게 만들기   ( hashCode, equals)
//
//3. Iterator로 출력하기 - 사용자정보,총점, 평균