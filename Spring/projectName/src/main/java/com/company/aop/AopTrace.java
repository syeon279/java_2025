package com.company.aop;
 
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopTrace {
	// Aspect = Advice(부가기능정의) + PointCut(적용부위)
	@Around("execution(public * com.company..*(..))")
	public Object trace( ProceedingJoinPoint joinPoint ) throws Throwable {
		//1. target의 메서드정보
		String  signature=  joinPoint.getSignature().toShortString();
		System.out.println(">>>>" + signature + " start!");
		
		//2. 호출시간 확인
		long start = System.currentTimeMillis();
		
		//3. target 메서드실행
		Object result = joinPoint.proceed();
		long end = System.currentTimeMillis();
		
		System.out.println(".... 실행시간 : " + (end-start) + "ms");
		System.out.println(">>>>" + signature + " end!");
		return result;
	} 
}
//  execution(  * hello(..)  )  hello 메서드 / 파라미터 종류들 다
//  execution(  * hello(  )  )  hello 메서드 / 파라미터 X 
//  execution( public   *  com.company..*(..)  )  ..서브패키지들의 모든클래스