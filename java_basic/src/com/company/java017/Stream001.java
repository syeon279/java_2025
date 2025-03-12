package com.company.java017;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Stream001 {
	public static void main(String[] args) {
		//데이커 종류에 상관없이 같은 방식으로 처리
		
		Integer[] arr = {1,2,3,4,5}; // 배열
		List<Integer> list = Arrays.asList(arr); // 리스트
		
		Arrays.stream(arr).forEach((t)->{System.out.println(t);});
//		Consumer <? super Integer> action
		//Consumer <Number> action; // Integer 포함 부모
//		Consumer <Number> action;
		Arrays.stream(arr).forEach( t->System.out.println(t) );
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
		list.stream().forEach(System.out::print);
		
	} // E main
} // E class
