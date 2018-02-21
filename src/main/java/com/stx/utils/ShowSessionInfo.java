package com.stx.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class ShowSessionInfo {
	private Jedis jedis;
	@Before
	public void before(){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(30);
		config.setMaxIdle(2);
		JedisPool pool = new JedisPool(config, IpService.REDIS_IP, 6379);
		jedis = pool.getResource();
	}
	@After
	public void after(){
		if(jedis != null){
			jedis.close();
		}
	}
	
	@Test
	public void getAllSession(){
		//jedis.rpush("aaa", "xxx");
	}
	
	@Test
	public  void format(){
		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(dateFormat.format(d));
	}
}
