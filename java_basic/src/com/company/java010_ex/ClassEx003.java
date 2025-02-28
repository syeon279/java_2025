package com.company.java010_ex;
class Coffee {
	String name; int ea, price;
	//extendsㅜㅜㅜ
	public Coffee (String name, int ea, int price) { //직접 쓴 코드
		super();// 상속할때 사용
		this.name = name;
		this.ea = ea;
		this.price = price;
	}
	void show(){
		System.out.println("=====커피");
		System.out.println("커피명:  "+this.name);
		System.out.println("커피 잔 수: "+this.ea);
		System.out.println("가격: "+(this.price*this.ea));
	}
//	public Coffee(String name, int ea, int price) {
//		super(); // 이건 뭐하는거지??
//		this.name = name;
//		this.ea = ea;
//		this.price = price;
//	} //alt shift s - using filed 사용해서 생성자 만들어짐. 기본생성자가 취소가됨. 
	public Coffee() { // 이게 기본생성자인가? 파라미터가 없는거?
//		super;
		name = "아메리카노";
		ea = 1;
		price = 2000;
	}
}

public class ClassEx003 {

	public static void main(String[] args) {
		Coffee a1 = new Coffee("카페라떼", 2, 4000);
		a1.show();
		Coffee a2 = new Coffee(); // 기본생성자
		a2.show();
	}

}
//출력내용 :
//=====커피
//커피명 : 까페라떼
//커피잔수 : 2 
//커피가격 : 8000
//=====커피
//커피명 : 아메리카노
//커피잔수 : 1
//커피가격 : 2000