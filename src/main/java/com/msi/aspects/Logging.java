package com.msi.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
	final String BEFORE="execution(* com.msi.service.demoService.get*(..))";
	final String AFTER="execution(* com.msi.service.demoService.*(..))";
	final String ALL_METHODS_AFTER_A_SUB_DIRECTORY="execution(* com.msi.*.*.*(..))";
	final String ALLMETHODS_OF_A_BEAN_LAYER="bean(*Controller)";

	@Before(ALL_METHODS_AFTER_A_SUB_DIRECTORY)
	public void beforeGetMessage(JoinPoint joinPoint) {
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
		System.out.println(joinPoint.getSignature().getName()+" is about to be called");
	}
	@AfterReturning(pointcut=AFTER, returning="result")
	public void getReturn(JoinPoint joinPoint,Object result) {
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
		System.out.println("Returns: "+result);
	}
	
	@After(ALLMETHODS_OF_A_BEAN_LAYER)
	public void afterGetMessage(JoinPoint joinPoint) {
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
		System.out.println("Log: Method:" + joinPoint.getSignature().getName() + " || Parameters:"
				+ Arrays.asList(joinPoint.getArgs()));
	}
	
    @AfterThrowing (pointcut =AFTER, throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable  { 
    	 System.out.println("Exception " + ex);
    }
}
