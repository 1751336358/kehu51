package com.stx.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HttpAspact {
	@Before("execution(public * com.stx.controller.*.*(..))")
	public void before(JoinPoint point){		
	/*
		System.out.println("方法执行前");
		String methodName = point.getSignature().getName();	//获取调用的方法名
		String name = point.getSignature().getDeclaringTypeName();	//获取调用的类的全名
		Object[]args = point.getArgs();
		for(Object arg:args){
			System.out.println("参数："+arg.getClass().getName());
		}
		System.out.println("拦截的方法是:"+methodName);
		System.out.println("name:"+name);
	*/
	}
	/*
	@After("execution(public * com.stx.controller.UserController.*(..))")
	public void after(){
		System.out.println("方法执行后");
	}
	
	@AfterReturning("execution(public * com.stx.controller.UserController.*(..))")
	public void afterReturn(){
		System.out.println("returning后");
	}
	
	@AfterThrowing("execution(public * com.stx.controller.UserController.*(..))")
	public void afterThrowing(){
		System.out.println("抛出异常后");
	}
	
	@Around("execution(public * com.stx.controller.*.*(..))")
	public void around(ProceedingJoinPoint point){
	}
	*/
}
