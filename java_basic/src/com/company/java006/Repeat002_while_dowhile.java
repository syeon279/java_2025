package com.company.java006;

public class Repeat002_while_dowhile {

	public static void main(String[] args) {
		// 1.for ( 반복횟수를 알 때)
		for (int i = 1 ; i<=3 ; i++) {
			System.out.print(i + "\t"); 
		}
		System.out.println();
		
 		// 2. while ( 반복 횟수를 모를 때 - 실시간 게시판) 종료가 중요함 초기값 위로, 증감문은 맨 끝
		int i=1; while (i<=3) {
			System.out.print(i + "\t"); i++;
		} 
		System.out.println();
			
		// 3. do while (무조건 1번은 실행을 해야할 때)
		i = 1;
		do {
			System.out.print(i + "\t"); i++;
		} while (i<=3);
		System.out.println();
	}

}
