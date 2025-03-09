package com.company.java014_ex;

interface Calc{
	public double exec(double num1, double num2);
}

public class NonameClassEx001 {

	public static void main(String[] args) {
		Calc calc = new Calc() {
			@Override
			public double exec(double num1, double num2) {
				return num1+num2;
			}
		};
		System.out.println(calc.exec(10,3));
	}

}
//Calc calc = new Calc() X
//Calc calc = new Calc() {} O 