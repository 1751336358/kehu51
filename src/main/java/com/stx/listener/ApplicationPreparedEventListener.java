package com.stx.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

//@Component
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent>{

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		System.out.println("ApplicationPreparedEvent");
	}
}
