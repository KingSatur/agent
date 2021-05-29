package com.simulationproject.systemagent;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemAgentApplication {

	public static void main(String[] args)
			throws IOException, InterruptedException {
		SpringApplication.run(SystemAgentApplication.class,
				args);
	}

}
