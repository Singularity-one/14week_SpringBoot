package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonHeader {

	@JsonProperty("Id")
	public String id;
	
	@JsonProperty("clientIp")
	public String clientIp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	@Override
	public String toString() {
		return "CommonHeader [id=" + id + ", clientIp=" + clientIp + "]";
	}
}
