package com.stx.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import javax.annotation.Resource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.stx.pojo.SystemLog;
import com.stx.service.SystemLogService;
import com.stx.thread.HttpRequestThread;
import com.stx.thread.SystemLogThread;
import com.stx.utils.IpService;

@Component
@Aspect
public class SystemLogAspact {
	@Resource(name="systemLogServices")
	private SystemLogService systemLogService;
	@Autowired
	private ExecutorService executorService;
	@Autowired
	private RestTemplate restTemplate;
	
	@Before("execution(public * com.stx.controller.*.*(..))")
	public void before(JoinPoint point){
		String methodName = point.getSignature().getName();	//获取调用的方法名
		String className = point.getSignature().getDeclaringTypeName();	//获取调用的类的全名
		String operTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());	//获取操作时间
		SystemLog systemLog = new SystemLog(methodName,className,operTime);
		//多线程写日志
	//	executorService.execute(new SystemLogThread(this.systemLogService,systemLog));
		if(restTemplate == null){
			System.out.println("restTemplate == null");
			return;
		}else{
			//多线程异步发送请求
			String url = IpService.LOGSERVER_IP+"/LogServer/recieveLog";
		//	String url = IpService.LOGSERVER_IP_NGINX+"/LogServer/recievelog";
			//这里设计成泛型，可以发送不同的对象，方便以后系统拓展
			executorService.execute(new HttpRequestThread<SystemLog>(restTemplate, url,systemLog));
		}
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
