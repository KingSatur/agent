package com.simulationproject.systemagent.rest.dto;

public class RequestChangeOperatorSystemDateDTO {

	private String date;
	private String time;

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
