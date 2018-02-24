package com.stx.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

//@Component
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent>{

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("ApplicationStartedEvent");
	}
}
