package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vendor;
import com.example.demo.respository.VendorRespository;
import com.example.demo.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
	public VendorRespository vendorRespository;
	
	@Override
	public List<Vendor> findAll() {
		return vendorRespository.findAll();
	}

	@Override
	public void save(Vendor vendor) {
		vendorRespository.save(vendor);
	}

	@Override
	public void delete(Vendor vendor) {
		vendorRespository.delete(vendor);
	}

	@Override
	public void upData(Vendor vendor) {
		vendorRespository.save(vendor);
	}

	@Override
	public List<Vendor> findByNameLike(String name) {
		return vendorRespository.findByNameLike("%"+name+"%");
	}

	@Override
	public List<Vendor> findBySQL(String name, String addr) {
		return vendorRespository.findBySQL(name,addr);
	}

	@Override
	public List<Vendor> findAllByPage(int page, int size) {
		  	Page<Vendor> pageResult = vendorRespository.findAll(
	                PageRequest.of(page,  // 查詢的頁數，從0起算
	                                size, // 查詢的每頁筆數
	                                Sort.by("id").ascending())); // 依ID欄位排序
		  	
	        return pageResult.getContent();
	}

	

}
