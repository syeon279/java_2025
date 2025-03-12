package com.company.java017;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda004_api {

	public static void main(String[] args) {
		// #1. Consumer 받는 용도 - accept
		//void java.util.function.Consumer.accept ( T t )
		//	()->{}	파라미터 o / 리턴값 X 
		//Consumer<String> consumer = (t)->{System.out.println("안녕, " + t);};
		//Consumer<String> consumer = t->System.out.println("안녕, " + t);
		Consumer<String> consumer =  System.out::println;
		consumer.accept("안녕, 단이");
		
		
		// #2.
		//()->{return}  파라미터 x / 리턴값 o 
		//Supplier<String> supplier = ()-> {return "헬로";};
		Supplier<String> supplier = ()->"헬로";
		System.out.println(supplier.get()); // 헬로
		
		// #3.
		//1. 메서드 찾기
		// 2. ( t )->{ return } 파라미터 o / 리턴값 o 유무
		//Predicate<Integer> predicate = (t)->{ return t<0;};
		Predicate<Integer> predicate = t -> t<0;
		System.out.println(predicate.test(-1));
		System.out.println(predicate.test(1));
		
		
		// #4. 
		//Function<String, Integer> function = (str)-> {return Integer.parseInt(str);};
		//Function<String, Integer> function = str-> Integer.parseInt(str);
		Function<String, Integer> function = Integer::parseInt;
		System.out.println(function.apply("10")+3); // 13
		
		//#5.
		//IntBinaryOperator operator = (a, b)->{return Math.max(a, b);};
		IntBinaryOperator operator = (a, b)->{return (a>=b? a : b);};
//		IntBinaryOperator operator = Math::max;
		System.out.println(operator.applyAsInt(10, 3));
	}

}
