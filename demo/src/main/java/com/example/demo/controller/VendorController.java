package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VendorRequest;
import com.example.demo.dto.VendorResponse;
import com.example.demo.dto.VendorResponseBody;
import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	public VendorService vendorService;
	
	@GetMapping(value = "/test")
	public String test() {
	        return "Hello Spring Boot";
	}
	
	
	@GetMapping(value = "/findAll")
	@ResponseBody
	public VendorResponse findAll() {

		VendorResponse response = new VendorResponse();
		List<Vendor> dataList = vendorService.findAll();
		VendorResponseBody body = new VendorResponseBody();
		body.setReturnCode("200");
		body.setDataList(dataList);
		response.setBody(body);

		return response;
	}
	
	@PostMapping(value = "/save")
	@ResponseBody
	public VendorResponse save(@RequestBody VendorRequest request) {
		
		VendorResponse response = new VendorResponse();
		VendorResponseBody body = new VendorResponseBody();
		Vendor vendor = new Vendor();
		List<String> errorMsgs = new LinkedList<String>();
		
		try {
			BeanUtils.copyProperties(request.getBody(), vendor);
			
			String id = vendor.getId();
			if (id == null || id.trim().length() == 0) {
				errorMsgs.add("id: ????????????");
			}
			
			String name = vendor.getName();
			if (name == null || name.trim().length() == 0) {
				errorMsgs.add("name: ????????????");
			}
			
			String addr = vendor.getAddr();
			if (addr == null || addr.trim().length() == 0) {
				errorMsgs.add("addr: ????????????");
			}
			
			String tel = vendor.getTel();
			if (tel == null || tel.trim().length() == 0) {
				errorMsgs.add("tel: ????????????");
			}
			
			if (!errorMsgs.isEmpty()) {
				body.setReturnCode("error");
				body.setReturnMsg(errorMsgs);
				response.setBody(body);
				return response; //????????????
			}
			
			//??????????????????
			vendorService.save(vendor);
			body.setReturnCode("200");
			response.setBody(body);
			return response;
			
		}catch (Exception e) {
			errorMsgs.add("??????????????????:"+e.getMessage());
			body.setReturnCode("error");
			body.setReturnMsg(errorMsgs);
			response.setBody(body);
			return response;
		}
	}
	
	@PostMapping(value = "/delete")
	@ResponseBody
	public VendorResponse delete(@RequestBody VendorRequest request) {
		
		VendorResponse response = new VendorResponse();
		VendorResponseBody body = new VendorResponseBody();
		Vendor vendor = new Vendor();
		List<String> errorMsgs = new LinkedList<String>();
		
		try {
			BeanUtils.copyProperties(request.getBody(), vendor);
			
			String id = vendor.getId();
			if (id == null || id.trim().length() == 0) {
				errorMsgs.add("id: ????????????");
			}
			
			if (!errorMsgs.isEmpty()) {
				body.setReturnCode("error");
				body.setReturnMsg(errorMsgs);
				response.setBody(body);
				return response; //????????????
			}
			
			//??????????????????
			vendorService.delete(vendor);
			body.setReturnCode("200");
			response.setBody(body);
			return response;
			
		}catch (Exception e) {
			errorMsgs.add("??????????????????:"+e.getMessage());
			body.setReturnCode("??????????????????");
			body.setReturnMsg(errorMsgs);
			response.setBody(body);
			return response;
		}
	}
	
	@PostMapping(value = "/upData")
	@ResponseBody
	public VendorResponse upData(@RequestBody VendorRequest request) {
		
		VendorResponse response = new VendorResponse();
		VendorResponseBody body = new VendorResponseBody();
		Vendor vendor = new Vendor();
		List<String> errorMsgs = new LinkedList<String>();
		
		try {
			BeanUtils.copyProperties(request.getBody(), vendor);
			
			String id = vendor.getId();
			if (id == null || id.trim().length() == 0) {
				errorMsgs.add("id: ????????????");
			}
			
			String name = vendor.getName();
			if (name == null || name.trim().length() == 0) {
				errorMsgs.add("name: ????????????");
			}
			
			String addr = vendor.getAddr();
			if (addr == null || addr.trim().length() == 0) {
				errorMsgs.add("addr: ????????????");
			}
			
			String tel = vendor.getTel();
			if (tel == null || tel.trim().length() == 0) {
				errorMsgs.add("tel: ????????????");
			}
			
			if (!errorMsgs.isEmpty()) {
				body.setReturnCode("error");
				body.setReturnMsg(errorMsgs);
				response.setBody(body);
				return response; //????????????
			}
			
			//??????????????????
			vendorService.save(vendor);
			body.setReturnCode("200");
			response.setBody(body);
			return response;
			
		}catch (Exception e) {
			errorMsgs.add("??????????????????:"+e.getMessage());
			body.setReturnCode("error");
			body.setReturnMsg(errorMsgs);
			response.setBody(body);
			return response;
		}
	}
	
	//??????????????????
	@RequestMapping(value = "/findByNameLike", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public VendorResponse findByNameLike(@RequestBody VendorRequest request) {
		
			VendorResponse response = new VendorResponse();
			VendorResponseBody body = new VendorResponseBody();
			Vendor vendor = new Vendor();
			List<String> errorMsgs = new LinkedList<String>();
			
			try {
				BeanUtils.copyProperties(request.getBody(), vendor);
				
				String name = vendor.getName();
				if (name == null || name.trim().length() == 0) {
					errorMsgs.add("name: ????????????");
				}
				
				
				if (!errorMsgs.isEmpty()) {
					body.setReturnCode("error");
					body.setReturnMsg(errorMsgs);
					response.setBody(body);
					return response; //????????????
				}
				
				//??????????????????
				List<Vendor> dataList = vendorService.findByNameLike(name);
				body.setReturnCode("200");
				body.setDataList(dataList);
				response.setBody(body);
				
				return response;
				
			}catch (Exception e) {
				errorMsgs.add("??????????????????:"+e.getMessage());
				body.setReturnCode("error");
				body.setReturnMsg(errorMsgs);
				response.setBody(body);
				return response;
			}
	}
	
	//??????SQL
	@RequestMapping(value = "/findBySQL", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public VendorResponse findBySQL(@RequestBody VendorRequest request) {

		VendorResponse response = new VendorResponse();
		VendorResponseBody body = new VendorResponseBody();
		Vendor vendor = new Vendor();
		List<String> errorMsgs = new LinkedList<String>();
		
		try {
			BeanUtils.copyProperties(request.getBody(), vendor);
			
			String name = vendor.getName();
			if (name == null || name.trim().length() == 0) {
				errorMsgs.add("name: ????????????");
			}
			
			String addr = vendor.getAddr();
			if (addr == null || addr.trim().length() == 0) {
				errorMsgs.add("addr: ????????????");
			}
			
			if (!errorMsgs.isEmpty()) {
				body.setReturnCode("error");
				body.setReturnMsg(errorMsgs);
				response.setBody(body);
				return response; //????????????
			}
			
			//??????????????????
			List<Vendor> dataList = vendorService.findBySQL(name,addr);
			body.setReturnCode("200");
			body.setDataList(dataList);
			response.setBody(body);
			
			return response;
			
		}catch (Exception e) {
			errorMsgs.add("??????????????????:"+e.getMessage());
			body.setReturnCode("error");
			body.setReturnMsg(errorMsgs);
			response.setBody(body);
			return response;
		}
	}
	
	//????????????
	@PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public VendorResponse page(@RequestBody VendorRequest request) {
		VendorResponse response = new VendorResponse();
		VendorResponseBody body = new VendorResponseBody();
		Vendor vendor = new Vendor();
		List<String> errorMsgs = new LinkedList<String>();
		
		try {
			
			String page = request.getBody().getPage();
			if (page == null || page.trim().length() == 0) {
				errorMsgs.add("page: ????????????");
			}
			
			String size = request.getBody().getSize();
			if (size == null || size.trim().length() == 0) {
				errorMsgs.add("size: ????????????");
			}
			
			if (!errorMsgs.isEmpty()) {
				body.setReturnCode("error");
				body.setReturnMsg(errorMsgs);
				response.setBody(body);
				return response; //????????????
			}
			
			//??????????????????
			int IntPage = Integer.parseInt(page);
			int IntSize = Integer.parseInt(size);
			
			List<Vendor> dataList = vendorService.findAllByPage(IntPage,IntSize);
			body.setReturnCode("200");
			body.setDataList(dataList);
			response.setBody(body);
			
			return response;
			
		}catch (Exception e) {
			errorMsgs.add("??????????????????:"+e.getMessage());
			body.setReturnCode("error");
			body.setReturnMsg(errorMsgs);
			response.setBody(body);
			return response;
		}	
	}
	
}
