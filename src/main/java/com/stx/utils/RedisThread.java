package com.stx.utils;

import java.util.Random;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisThread implements Runnable{
	private JedisPool pool;
	public RedisThread(JedisPool pool){
		this.pool = pool;
	}
	@Override
	public void run() {
		try {
			//调用客户端
			client();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	/**
	 * 获得锁
	 */
	public boolean getLock(){
		Jedis jedis = pool.getResource();
		Long ret = jedis.setnx("k", "v");
		//ret==1，获得锁
		if(ret == 1){
	//		System.out.println(Thread.currentThread().getName()+":lock");
			//如果某个客户端挂掉没有执行del操作,则设置超时时间释放锁，否则会死锁。
			jedis.expire("k",10);
			jedis.close();
			return true;
		}
		//没有获得锁
		jedis.close();
		return false;
	}
	
	/**
	 * 模拟客户端
	 * @throws Exception
	 */
	public void client() throws Exception{
		boolean b = getLock();
		//如果没有获得锁，持续监听
		while(!b){
			b = getLock();
		}
		System.out.println(Thread.currentThread().getName()+"执行业务开始"+System.currentTimeMillis());
		Long startTime = System.currentTimeMillis();
//		Thread.sleep(new Random().nextInt(1000));
		Thread.sleep(1000);
	//	System.out.println(Thread.currentThread().getName()+"执行业务结束，共用时"+(System.currentTimeMillis()-startTime)+"ms");
		Jedis jedis = pool.getResource();
		jedis.del("k");	//unlock
		jedis.close();
//		System.out.println(Thread.currentThread().getName()+"unlock");
	}

}
