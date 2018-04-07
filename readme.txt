当IP发生变化时需要更改的配置
	应用程序端:com.stx.utils.IPService.java
		redis_ip
		activemq_ip
		nginx_ip
	Linux端：
		nginx.conf:修改两个负载均衡的ip（LogService所在的主机的IP和端口）
		nginx的主要配置如下（还需优化）：
在部署系统时首先部署日志服务器：详情见 https://github.com/1751336358/LogServer
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
部署系统时必须需要的三张数据表是department、authority、menu表，否则系统无法运行，手动从项目sql目录导入:
	mysql -uroot -pmysqladmin kehu51 < department.sql
	mysql -uroot -pmysqladmin kehu51 < authority.sql
	mysql -uroot -pmysqladmin kehu51 < menu.sql
		
