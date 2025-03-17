package com.company.java018;

class Milk {
	private String name;
	private int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Milk(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
} // E class

class MilkPrint {

	public void show(Milk[] milks) {
		for(Milk m : milks) {
			System.out.println( m.getName() + " / " + m.getPrice() );
		}
	}
	
}

public class Repeat001 {

	public static void main(String[] args) {
		Milk []milks = new Milk[3];   
		milks[0] = new Milk("white",1000);
		milks[1] = new Milk("choco",1200);
		milks[2] = new Milk("banana",1500);
		
		MilkPrint  print = new MilkPrint();   
		print.show(  milks     );
		
	}

}
