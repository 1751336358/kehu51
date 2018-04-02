package com.stx.utils;

import redis.clients.jedis.Jedis;
/**
 * 封装ThreadLocal与jedis，每次拿出本线程中的Jedis，解决并发问题
 * @author LL
 *	2018-04-02
 */
public class MyThreadLocal {
	public static ThreadLocal<Jedis> threadLocal = new ThreadLocal<Jedis>(){

		@Override
		protected Jedis initialValue() {
			
			return super.initialValue();
		}
		
	};
}
