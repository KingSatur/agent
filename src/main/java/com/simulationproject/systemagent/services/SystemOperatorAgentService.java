package com.simulationproject.systemagent.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class SystemOperatorAgentService {

	public void executeCommand(String date, String time) {
		if (System.getProperty("os.name").contains("linux")
				|| System.getProperty("os.name")
						.contains("Linux")) {
			try {
				this.runLinuxCommand(date, time);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (System.getProperty("os.name")
				.contains("Windows")
				|| System.getProperty("os.name")
						.contains("windows")) {
			try {
				this.runWindowsCommand(date, time);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void runWindowsCommand(String date, String time)
			throws IOException, InterruptedException {
		final Process dateProcess = Runtime.getRuntime()
				.exec("cmd /c date " + date);
		dateProcess.waitFor();
		final Process timeProcess = Runtime.getRuntime()
				.exec("cmd /c time " + time);
		timeProcess.waitFor();

	}

	public void runLinuxCommand(String date, String time)
			throws IOException, InterruptedException {
		String day = date.substring(3, 5);
		String month = date.substring(0, 2);
		String year = date.substring(6, 10);
		String hour = time.substring(0, 2);
		String minute = time.substring(3, 5);
		String completeDate = month + day + hour + minute
				+ year;
		final Process dateProcess = Runtime.getRuntime()
				.exec(String.format("date %s",
						completeDate));
		dateProcess.waitFor();

	}

}
