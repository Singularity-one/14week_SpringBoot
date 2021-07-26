package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Vendor;

public class VendorResponseBody {
	private String returnCode;
	
	private List<String> returnMsg;

	private List<Vendor> dataList;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public List<String> getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(List<String> returnMsg) {
		this.returnMsg = returnMsg;
	}

	public List<Vendor> getDataList() {
		return dataList;
	}

	public void setDataList(List<Vendor> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "VendorResponseBody [returnCode=" + returnCode + ", returnMsg=" + returnMsg + ", dataList=" + dataList
				+ "]";
	}

}
