package com.stx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@SpringBootApplication
//扫描mapper
@MapperScan("com.stx.*")
//让@WebFilter起作用
@ServletComponentScan("com.stx*")
//在配置文件中写spring.session.store-type=redis就不用下面这行注解了
//@EnableRedisHttpSession
public class App {
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(App.class);
       /* 
        app.addListeners(new ApplicationStartedEventListener());
        app.addListeners(new ApplicationPreparedEventListener());
        app.addListeners(new ApplicationReadyEventListener());
        app.addListeners(new ApplicationFailedEventListener());
        app.addListeners(new ApplicationEnvironmentPreparedEventListener());
		*/
        
        app.run(args);
	}
}