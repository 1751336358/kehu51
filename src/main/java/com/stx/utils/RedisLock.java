package com.stx.utils;

import java.util.Random;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisLock {
	public static void main(String[] args) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(50);
		config.setMaxTotal(50);
		JedisPool pool = new JedisPool(config, "127.0.0.1", IpService.REDIS_PORT);
		
		Thread[] t = new Thread[50];
		for(int i = 0;i<t.length;i++){
			t[i] = new Thread(new RedisThread(pool));
		}
		for(int i = 0;i<t.length;i++){
			t[i].start();
		}
		
	}
}
