package com.stx.utils;

class MyThread implements  Runnable {
	@Override
	public void run() {
		System.out.println("线程开始");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println("线程结束");
	}
}
public class Test {

	
	public static  int fun(){
		Thread t = new Thread(new MyThread());
		t.start();
		return 1;
	}
	
	public static void main(String[] args) {
		int ret = fun();
		System.out.println("返回值:"+ret);
		System.out.println("处理其他业务");
		return;
	}
	
}
