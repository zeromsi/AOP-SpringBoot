package com.msi.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

	@Before("execution(* com.msi.service.demoService.get*(..))")
	public void beforeGetMessage(JoinPoint joinPoint) {
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
		System.out.println(joinPoint.getSignature().getName()+" is about to be called");
	}

	@After("execution(* com.msi.service.demoService.*(..))")
	public void afterGetMessage(JoinPoint joinPoint) {
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
		System.out.println("Log: Method:" + joinPoint.getSignature().getName() + " || Parameters:"
				+ Arrays.asList(joinPoint.getArgs()));
	}
}
