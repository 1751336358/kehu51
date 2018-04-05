package com.stx.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.stx.pojo.SystemLog;

/**
 * 系统配置类
 * @author LL
 *	2018-03-23
 */
@Configuration
public class MyConfiguration {
	/**
	 * 注入一个线程池
	 * @return
	 */
	@Bean
	public ExecutorService executorService(){
		ExecutorService executorService = Executors.newFixedThreadPool(30);
		return executorService;
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
