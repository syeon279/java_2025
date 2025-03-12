package com.company.java017;

interface InterTest21 {
	void test();
}
interface InterTest22 {
	void test(int a);
}
interface InterTest23 {
	int test();
}
interface InterTest24 {
	int test(int a);
}

public class Repeat003 {

	public static void main(String[] args) {
		InterTest21 test1 = ()-> System.out.println("안녕");
		test1.test();
		
		InterTest22 test2 = (int a)-> System.out.println("안녕! ".repeat(a));
		test2.test(2);
		
		InterTest23 test3 = ()-> 3;
		System.out.println(test3.test());
		
		InterTest24 test4 = (int a)-> a*10;
		System.out.println(test4.test(3));
	}

}
