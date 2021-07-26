package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendorRequestBody {
	@JsonProperty("id")
	public String id;

	@JsonProperty("name")
	public String name;

	@JsonProperty("addr")
	public String addr;

	@JsonProperty("tel")
	public String tel;
	

	@JsonProperty("page")
	public String page;
	
	@JsonProperty("size")
	public String size;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "VendorRequestBody [id=" + id + ", name=" + name + ", addr=" + addr + ", tel=" + tel + ", page=" + page
				+ ", size=" + size + "]";
	}
	
}
