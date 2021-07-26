package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Vendor;
import com.example.demo.respository.VendorRespository;
import com.example.demo.service.VendorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorServiceTest {
	@Autowired
    private VendorService vendorService;
	
	@MockBean
    private VendorRespository vendorRespository;


	@Test
  	public void findBySQL() throws Exception {
		//mock vendorRespository的findBySQL()方法
		List<Vendor> dataList = new ArrayList<Vendor>();
		Vendor vendor =new Vendor();
		vendor.setId("2");
		vendor.setName("Tom");
		vendor.setAddr("USA");
		vendor.setTel("0945123456");
		dataList.add(vendor);
		Mockito.when(vendorRespository.findBySQL("Tom","USA")).thenReturn(dataList);

		
		List<Vendor> OutputDataList = vendorService.findBySQL("Tom","USA");
      
		Assert.assertNotNull(OutputDataList);
		Assert.assertEquals(OutputDataList.get(0).getId(), "2");
		Assert.assertEquals(OutputDataList.get(0).getTel(), "0945123456");
      
  }
}
