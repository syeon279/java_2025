package com.company.java017;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream002 {
	public static void main(String[] args) {
		// 데이터 종류 상관없이 같은 방식으로 처리
		Integer[] arr = {3,5,1,2,4,4,1};
		List<Integer> list = Arrays.asList(arr);
		
		//1. stream으로 변환
		Stream<Integer> stream_arr = Arrays.stream(arr);
		Stream<Integer> stream_list = list.stream();
		
		//2. 중간연산 
		//
//		boolean java.util.function.Predicate.test ( T t )
		stream_arr.filter(t->t%2!=0) // 홀수 : 필터링
					.distinct() 	// 중복제거
					.sorted()		// 정렬
					.skip(1)		//skip
					.forEach(t-> { System.out.println(t);}); 
		//Predicate <? super Integer> predicate
		
		System.out.println("=====list");
		stream_list.filter(t->t%2!=0) // 홀수 : 필터링
			.distinct() 	// 중복제거
			.sorted()		// 정렬
			.skip(1)		//skip
			.forEach(System.out::println); 
		
		// 3. collect
		System.out.println( Arrays.stream(arr).collect(Collectors.toList()));
		System.out.println( list.stream().collect(Collectors.toList()));
		
	}
}
