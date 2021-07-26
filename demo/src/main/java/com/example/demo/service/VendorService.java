package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Vendor;

public interface VendorService {
	
	List<Vendor> findAll();
	
	void save(Vendor vendor);
	
	void delete (Vendor vendor);
	
	void upData(Vendor vendor);
	
	//名字查詢
	List<Vendor> findByNameLike(String name);
		
	//輸入條件用SQL找
	List<Vendor> findBySQL(String name,String addr);
	
	//頁碼
	List<Vendor> findAllByPage(int page,int size);
	
}
