package com.company.java010_ex;
class Card{
	int cardNum; boolean  isMembership;   
	public Card() { super();
		this.cardNum = 1;
		this.isMembership = true;
	} //Card(): 1. 원래는 생략되어있음. 컴파일러가 자동생성
	//Card(): 2. 기본생성자는 사용자가 많이 사용하는 기본 세팅이 들어감. cardNum =1; isMembership = true;
	public Card(int cardNum, boolean isMembership) {
		super();
		this.cardNum = cardNum; this.isMembership = isMembership;
	}
	@Override
	public String toString() {
		return "Card [cardNum=" + cardNum + ", isMembership=" + isMembership+ "]";
	}
	
}
public class ClassEx005 {

	public static void main(String[] args) {
		Card  c1= new Card(); 
	    System.out.println(c1);  
	    
	    Card c2 = new Card(3, false);
	    System.out.println(c2);
	    
	}

}

//출력내용 :
//Card[cardNum=0, isMembership=false]