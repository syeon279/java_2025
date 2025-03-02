package com.company.java010;

class Product{
	String name;
	int price;
	//alt shifr s 
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Product() {
		System.out.println("원하는 값으로 초기화- 수동생성시 컴파일러 자동생성 취소");
		//String 문자열은 null로 초기화/ int = 0 으로 초기화 
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	//@Override - 자식 클래스(Product)에 맞게 수정 - 값 출력
}

public class Class004 {

	public static void main(String[] args) {
		Product p1 = new Product(); //#3
		System.out.println(p1);
	}

}
/*
----------------------------------------------------------------------------- runtime 
[method]	Product.class, Class004.class  #1
------------------------------------------------------------------------------
[heap]            								  	| [stack]
1번지: {name=null, price=0}	// 생성자가 하는 일			<- p1 
					 								|	main #2
------------------------------------------------------------------------------
*/
