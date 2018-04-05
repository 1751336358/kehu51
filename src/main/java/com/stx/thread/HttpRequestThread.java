package com.stx.thread;

import org.springframework.web.client.RestTemplate;
/**
 * 多线程发送httprequest
 * @author LL
 *	2018-04-05
 */
public class HttpRequestThread<T> implements Runnable{
	private RestTemplate restTemplate;
	private String url;		//请求的url
	private T requestObj;	//post请求传递的参数
	public HttpRequestThread(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
	}
	public HttpRequestThread(RestTemplate restTemplate,String url){
		this.restTemplate = restTemplate;
		this.url = url;
	}
	//这里设计成泛型，可以发送不同的对象，方便以后系统拓展
	public HttpRequestThread(RestTemplate restTemplate,String url,T requestObj){
		this.restTemplate = restTemplate;
		this.url = url;
		this.requestObj = requestObj;
	}
	@Override
	public void run() {
		//多线程异步发送请求
		Integer ret = restTemplate.postForObject(url, requestObj, Integer.class);
	}

}
