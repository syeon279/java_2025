package com.company.java011;

import com.company.java011_ex.Score;

public class ModifierEx2 {
	public static void main(String[] args) {
		 Score iron = new Score();     
	     Score hulk = new Score("hulk" , 20,50,30);    
	     iron.setName("iron"); iron.setKor(100); iron.setEng(100); iron.setMath(100);
	      
	     Score.Info();     // 클래스메서드
	     // public static 리턴값 메서드명() {해야할 일}
	     iron.show();          
	     hulk.show();   
	}

}
