package com.simulationproject.systemagent;

import java.io.IOException;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SystemAgentApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(SystemAgentApplication.class, args);

//		System.out.println(System.getProperty("os.name"));
//		System.out.println(System.getProperty("os.version"));
//		System.out.println(System.getProperty("os.arch"));
	}

}
