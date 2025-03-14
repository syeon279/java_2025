package com.company.java019;

import java.util.Scanner;

class Count extends Thread {
	@Override
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				break;
			}
		}
	} //E run
}// E class

public class Thread004_Interrupt {

	public static void main(String[] args) {
		Thread count = new Count(); count.start();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("카운트를 해제하시겠습니까? y or n");
		if(scanner.next().equals("y")) {
			System.out.println("카운트가 해제되었습니다.");
			count.interrupt();
		}
		System.out.println("End : Main");
	}

}
