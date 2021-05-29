package com.simulationproject.systemagent.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SystemOperatorAgentServiceTest {

	@Autowired
	private SystemOperatorAgentService service;

	@Test
	void test() throws IOException, InterruptedException {
		String newDate = "05-24-2021";
		String time = "23:40";
		this.service.executeCommand(newDate, time);
		TimeUnit.SECONDS.sleep(2);
		LocalDateTime localTime = LocalDateTime.now();
		assertEquals(localTime.getDayOfMonth(), 24);
		assertTrue(localTime.toString().contains(time));
		LocalDateTime l = new Timestamp(
				System.currentTimeMillis())
						.toLocalDateTime();
		System.out.println(l.toString());
		assertEquals(l.getDayOfMonth(), 24);
		assertTrue(l.toString().contains(time));
	}

}
