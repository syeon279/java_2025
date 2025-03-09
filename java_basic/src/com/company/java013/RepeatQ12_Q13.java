package com.company.java013;

class A {
	private String name;
 public String getName() { return name; }  
 public void setName(String name) { this.name = name; }

	A(){
	}
	@Override
	public String toString() {
		return "A [name=" + name + "]";
	}
	
}

public class RepeatQ12_Q13 {

	public static void main(String[] args) {
		A[] arr = new A[3];
		arr[0] = new A(); arr[1] = new A(); arr[2]= new A();
		// 생성자를 호출해 인스턴스변수를 사용가능하게 만들어야함. 
		for(A name: arr) {
			System.out.println(name);
		}
		
	}

}
