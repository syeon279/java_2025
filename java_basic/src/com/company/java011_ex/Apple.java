package com.company.java011_ex;

public class Apple {
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public String getOrder() { return order; } public void setOrder(String order) { this.order = order; }
	public int getNum() { return num; } public void setNum(int num) { this.num = num; }
	public int getPrice() { return price; } public void setPrice(int price) { this.price = price; }
	@Override
	public String toString() {
		return "Apple [name=" + name + ", order=" + order + ", num=" + num + ", price=" + price + "]";
	}
	private String name;
	private String order;
	private int num;
	private int price;
	
}
