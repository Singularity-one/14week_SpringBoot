package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendorResponse {
	@JsonProperty("header")
	public CommonHeader header;

	@JsonProperty("body")
	public VendorResponseBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public VendorResponseBody getBody() {
		return body;
	}

	public void setBody(VendorResponseBody body) {
		this.body = body;
	}


	@Override
	public String toString() {
		return "VendorResponse [header=" + header + ", body=" + body + "]";
	}
}
