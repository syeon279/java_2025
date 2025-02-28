package com.company.java010_ex;

import java.util.Scanner;

class Calc{
	static String name ="**계산기**";
	int num1, num2;  char op;  String result;
	void input()  {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자 1 입력> "); num1 = scanner.nextInt();
		System.out.print("숫자 2 입력> "); num2 = scanner.nextInt();
		System.out.print("연산자 입력> "); op = scanner.next().charAt(0);
	}
	void opcalc() {
		switch(op) {
		case '+': result = ""+ (num1 + num2); break;
		case '-': result = ""+ (num1 - num2); break;
		case '*': result = ""+ (num1 * num2); break;
		case '/': result = String.format("%.2f",num1/(double)num2);
		}
	}
	void show() {
		opcalc();
		System.out.println(""+num1+op+num2+"="+result);
		// result가 double일 경우 삼항연산자 사용. {op!='/'?(int)result : String.format("%.2f",result)} 
	}
	public Calc() {} // 생성자도 함수. 초기화에 특성화. 
	public Calc(int num1, int num2, char op) {
		this.num1 = num1;
		this.num2 = num2;
		this.op = op;
	}
}
public class ClassEx007 {

	public static void main(String[] args) {
		System.out.println(Calc.name); //클래스명.static변수 - new를 이용해서 사용x 바로 사용 가능
		System.out.println();
		Calc  c1= new Calc(10,3,'+');  
	    c1.show();
	    System.out.println(c1.name); //클래스명.static 변수
	    //The static field Calc.name should be accessed in a static way
	    Calc  c2= new Calc();  
	    c2.input();   
	    c2.show(); 
	}

}

/*  소스파일 													--컴파일(번역) ---   바이트코드
 * ClassEx007.java [class Calc{}/ class ClassEx007{}]  				       	 ClassEx007.class /Calc.class
 * ##Class Loader (클래스 파일을 띄어줌)

------------------------------------------------------------------- runtime 
[method: 정보, static, final/ 공유되는 영역. 메모리 상에 올라가 있음.] 
#1.  Calc.class / ClassEx007.class  / Calc.name[**계산기**] / main
--------------------------------------------------------------------
[heap: 동작]               						|   [stack: 임시]
2번지{num1,2,op,result}							<-   c2 : 2번지 
												     c1. show
1번지{num1=10,2,op,result} //1. new가 객체 생성    <-    c1 :1번지 //2. 초기화
											       println(Calc.name)     // new 안하고도 출력가능함. 
						  						|#2. static 붙은 애들 main
--------------------------------------------------------------------

 */
