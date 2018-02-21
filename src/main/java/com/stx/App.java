package com.stx;

import javax.servlet.annotation.WebFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
@SpringBootApplication
//扫描mapper
@MapperScan("com.stx.*")
//让@WebFilter起作用
@ServletComponentScan("com.stx*")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}