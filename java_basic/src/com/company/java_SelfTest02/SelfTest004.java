package com.company.java_SelfTest02;

class User004{
	private char divison;
	private String jumin;
	
	public User004() {
		super();
		divison = 'A';
		jumin = "123456-123456";
	}
	public User004(char divison, String jumin) {
		super();
		this.divison = divison;
		this.jumin = jumin;
	}
	
	public char getDivison() {
		return divison;
	}
	public void setDivison(char divison) {
		this.divison = divison;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	@Override
	public String toString() {
		return "User004 [divison=" + divison + ", jumin=" + jumin + "]";
	}
	
	
}

public class SelfTest004 {
	public static void main(String[] args) {
		User004 c1 = new User004('B',"200101-1234567");
		User004 c2 = new User004();
		
		System.out.println(c1);
		System.out.println(c2);
	}

}

// 접근자의 범위를 넓은 범위에서 좁은 범위로 적으시오
// public - protected - package -private
