package com.stx.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

//@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent>{

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		System.out.println("ApplicationPreparedEvent");
	}
}
