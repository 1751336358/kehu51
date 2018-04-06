当IP发生变化时需要更改的配置
	应用程序端:IPService.java
		redis_ip
		activemq_ip
		nginx_ip
	Linux端：
		nginx.conf:修改两个负载均衡的ip（LogService所在的主机的IP和端口）
		