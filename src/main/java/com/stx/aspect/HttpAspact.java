package com.stx.aspect;
/*
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class HttpAspact {
	@Before("execution(public * com.stx.controller.*.*(..))")
	public void before(){
		System.out.println("方法执行前");
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
	    String referer = request.getHeader("referer");
	    System.out.println("referer="+referer);
	}
	
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
	
}*/
