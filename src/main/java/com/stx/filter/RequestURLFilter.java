package com.stx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stx.pojo.User;
import com.stx.utils.IpService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@WebFilter(urlPatterns = {"/*"}, filterName = "requestURLFilter")
public class RequestURLFilter implements Filter{
	private FilterConfig cnf = null;
	private Jedis jedis;
	@Override
	public void destroy() {
		if(this.jedis != null){
			this.jedis.close();
		}
		Jedis jed = (Jedis)this.cnf.getServletContext().getAttribute("jedis");
		if(jed != null){
			if(jed.isConnected()){
				System.out.println("jed处于连接状态");
				jed.close();
			}
		}
		System.out.println("jedis销毁");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
/*		HttpSession session = request.getSession(true);
		User u = (User)session.getAttribute("user");
		if(u != null){
			int id = u.getId();
			String username = u.getUsername();
			String url = request.getRequestURL().toString();
			if(!url.endsWith(".png") && !url.endsWith(".jpg") && !url.endsWith(".css") && !url.endsWith(".js")){
				String query = request.getQueryString();
				//	System.out.println(url+query);
				//防止redis并发访问抛异常
				synchronized (jedis) {
					jedis.select(0);
					if(query == null){
						jedis.rpush(id+"_"+username, url);
					}else{
						jedis.rpush(id+"_"+username, url+"?"+query);
					}				
				}
			}
		}*/
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig cnf) throws ServletException {
		this.cnf = cnf;
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(30);
		config.setMaxIdle(2);
		
		
		JedisPool pool = new JedisPool(config, IpService.REDIS_IP, 6379);
		jedis = pool.getResource();
		this.cnf.getServletContext().setAttribute("jedis", jedis);
		System.out.println("jedis创建连接");
	}

}
