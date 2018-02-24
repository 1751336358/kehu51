package com.stx.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

//@Component
public class ApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent>{

	@Override
	public void onApplicationEvent(ApplicationFailedEvent event) {
		System.out.println("ApplicationFailedEvent");
	}
}
