package com.simulationproject.systemagent.rest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simulationproject.systemagent.rest.dto.RequestChangeOperatorSystemDateDTO;
import com.simulationproject.systemagent.services.SystemOperatorAgentService;

@RestController
@RequestMapping("/agent-operator")
public class SystemAgentController {

	private final SystemOperatorAgentService service;

	@Autowired
	public SystemAgentController(
			SystemOperatorAgentService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<?> changeSystemOperatorDate(
			@RequestBody RequestChangeOperatorSystemDateDTO requestDto) {
		try {
			this.service.executeCommand(
					requestDto.getDate(),
					requestDto.getTime());
			HashMap<String, Object> responseBody = new HashMap<>();

			Long timeStamp = System.currentTimeMillis();
			LocalDateTime l = new Timestamp(timeStamp)
					.toLocalDateTime();

			responseBody.put("date",
					l.format(DateTimeFormatter
							.ofPattern("MM-dd-yyyy")));
			responseBody.put("time", String.format("%s:%s",
					l.getHour(), l.getMinute()));
			responseBody.put("timestamp", timeStamp);
			return ResponseEntity.status(HttpStatus.OK)
					.body(responseBody);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			String msg = e.getMessage();
			String stackTrace = e.getStackTrace()
					.toString();
			HashMap<String, Object> responseBody = new HashMap<>();
			responseBody.put("errorMessage", msg);
			responseBody.put("stackTrace", stackTrace);
			return ResponseEntity.status(
					HttpStatus.INTERNAL_SERVER_ERROR)
					.body(responseBody);

		}
	}

}
