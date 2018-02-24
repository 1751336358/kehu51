package com.stx.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

//@Component
public class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>{

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		System.out.println("ApplicationEnvironmentPreparedEvent");
	}
}
