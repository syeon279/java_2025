package com.company.java015_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Fruits {
	private int no;   private  String name; private  int price;
	
	public int getNo() { return no; }  
	public void setNo(int no) { this.no = no; }
	public String getName() { return name; }  
	public void setName(String name) { this.name = name; }
	public int getPrice() { return price; }  
	public void setPrice(int price) { this.price = price; }
	
	public Fruits() {
		super();
	}
	public Fruits(int no, String name, int price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Fruits [no=" + no + ", name=" + name + ", price=" + price + "]";
	}
	
} // E class

public class ListEx004 {
	public static void main(String[] args) {
		List<Fruits> fruits = new ArrayList<>();
		fruits.add(new Fruits(1, "apple" , 2000));
		fruits.add(new Fruits(2, "banana" , 2500));
		fruits.add(new Fruits(3, "coconut" , 4500));
		
		for(Fruits f : fruits) {
			System.out.println(f);
		}
		
		String [] fruitinfo = {"사과는 빨갛다" , "바나나는 노랗다" , "코코넛은 코코하다"};
		int find = -1;
		Scanner scan = new Scanner(System.in);
		System.out.println("과일 번호를 입력> "); int num = scan.nextInt();
		for(int i=0;i<fruits.size();i++) {
			 if(num==(fruits.get(i)).getNo()) {
				 find = num-1; break;
			 }
		}
		if(find == -1) {
			System.out.println("과일을 찾을 수 없습니다.");
		} else {
			System.out.println("번호: "+ fruits.get(find).getNo()+", 이름: "+ fruits.get(find).getName()+", 가격: "+ fruits.get(find).getPrice());
			System.out.println(fruitinfo[find]); 
		}
	}// E main

}// E class
