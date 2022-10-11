package com.solactive.tickmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TickMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TickMonitorApplication.class, args);
	}

}
