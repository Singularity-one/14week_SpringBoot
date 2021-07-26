package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.dto.CommonHeader;
import com.example.demo.dto.VendorRequest;
import com.example.demo.dto.VendorRequestBody;
import com.example.demo.dto.VendorResponse;
import com.example.demo.entity.Vendor;
import com.example.demo.respository.VendorRespository;
import com.example.demo.service.VendorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorControllerTest extends AbstractTest{
	
	   @MockBean
	   private VendorService vendorService;
	
	   @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   
//	   @Test
//	   public void findAllTest() throws Exception {
//	      String uri = "/vendor/findAll";
//	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//	      
//	      int status = mvcResult.getResponse().getStatus();
//	      assertEquals(200, status);
//	      String content = mvcResult.getResponse().getContentAsString();
//	      
//	      System.out.println(content);
//	      
//	      VendorResponse datalist = super.mapFromJson(content, VendorResponse.class);
//	      Assert.assertEquals(datalist.getBody().getDataList().get(0).getId(), "1");
//	   }
	   
	   @Test
	   public void findBySQLTest() throws Exception {
	      String uri = "/vendor/findBySQL";
	      VendorRequest vendorRequest =new VendorRequest();
	      VendorRequestBody vendorRequestBody =new VendorRequestBody();
	      CommonHeader CommonHeader =new CommonHeader();
	      
	      vendorRequestBody.setName("Tom");
	      vendorRequestBody.setAddr("USA");
	      
	      vendorRequest.setHeader(CommonHeader);;
	      vendorRequest.setBody(vendorRequestBody);
	      
	      List<Vendor> dataList = new ArrayList<Vendor>();
			Vendor vendor =new Vendor();
			vendor.setId("2");
			vendor.setName("Tom");
			vendor.setAddr("USA");
			vendor.setTel("0945123456");
			dataList.add(vendor);
	      Mockito.when(vendorService.findBySQL("Tom","USA")).thenReturn(dataList);

	      String inputJson = super.mapToJson(vendorRequest);
	      System.out.println(inputJson);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println(content);
	      
	      VendorResponse datalist = super.mapFromJson(content, VendorResponse.class);
	      Assert.assertEquals(datalist.getBody().getDataList().get(0).getId(), "2");
	   }
}
