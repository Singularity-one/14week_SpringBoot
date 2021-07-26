package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Vendor;



@Repository
public interface VendorRespository extends JpaRepository<Vendor, String>{
	
	//用名子模糊查
	List<Vendor> findByNameLike(String name);
		
	//@Query查詢
	@Query(value = "select * from VENDOR  where name = ? and addr = ?", nativeQuery = true)
	List<Vendor> findBySQL(@Param("name") String name,  @Param("addr") String addr);
	
}
