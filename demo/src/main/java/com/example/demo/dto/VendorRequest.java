package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendorRequest {
	@JsonProperty("header")
	public CommonHeader header;
	
	@JsonProperty("body")
	public VendorRequestBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public VendorRequestBody getBody() {
		return body;
	}

	public void setBody(VendorRequestBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "VendorRequest [header=" + header + ", body=" + body + "]";
	}
}
