package com.stx.utils;
/**
 * 
 * @author LL
 *	2018-01-26
 *	IP服务
 */
public class IpService {
	/**
	 * ActiveMQ的IP地址
	 */
	public static final String ACTIVE_MQ_IP = "tcp://192.168.1.106:61616";
	/**
	 * redis主机和端口
	 */
	public static final String REDIS_IP = "192.168.1.106";
	public static final int REDIS_PORT = 6379;
	/**
	 * 本地日志服务器主机和端口
	 */
	public static final String LOGSERVER_IP = "http://127.0.0.1:8082";
	/**
	 * nginx负载均衡后的日志服务器IP
	 */
	public static final String LOGSERVER_IP_NGINX = "http://192.168.1.106";	//nginx所在的主机，监听的端口是80
	/*
	 upstream log {
		server 192.168.1.100:8082 weight=1;	#日志服务器所在的主机
		server 192.168.1.100:8083 weight=1;
	}
	
	server {
		access_log  logs/access.log  main;
		gzip	on;
		gzip_buffers	32 4k;
		gzip_comp_level	6;
		gzip_min_length	200;
		gzip_types	text/css application/javascript;
		#server_name	www.hyyx.com;
		
		#http://nginxHost:80/LogServer/recievelog
		listen 80;
		location /LogServer {
			proxy_pass	http://log;
			proxy_set_header Host $host;
                        proxy_set_header X-Forwarded-For $remote_addr;
		}
		location /err {
			return 403;
		}
		location /bad {
			return 500;
		}
	}
	  
	  
	 */
}
