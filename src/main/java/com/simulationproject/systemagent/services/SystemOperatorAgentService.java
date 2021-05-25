package com.simulationproject.systemagent.services;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SystemOperatorAgentService {
	
	public void executeCommand(String dateString) throws IOException, InterruptedException {
		Date date = new Date();
		System.out.println(date.getDate());
		final Process dateProcess = Runtime.getRuntime().exec("cmd /c date " + dateString);
		dateProcess.waitFor();
		Date date2 = new Date();
		System.out.println(date2.getDate());
	}


}
