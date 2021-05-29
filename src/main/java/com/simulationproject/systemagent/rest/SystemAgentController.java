package com.simulationproject.systemagent.rest;

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
	public ResponseEntity<String> changeSystemOperatorDate(
			@RequestBody RequestChangeOperatorSystemDateDTO requestDto) {
		try {
			this.service.executeCommand(
					requestDto.getDate(),
					requestDto.getTime());
			return ResponseEntity.status(HttpStatus.OK)
					.body("Date has been changed");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(
					HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error");

		}
	}

}
