package com.opw.vendor.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opw.vendor.model.VendorTypes;

public interface VendorRepo extends JpaRepository<VendorTypes, Integer> {

	List<VendorTypes> findAll();
	
	
	@Query(value="select distinct vt from VendorTypes vt ,Vendor v  where vt.vendortypeId = v.vendorType.vendortypeId and vt.vendorType in :vendorType")
	List<VendorTypes> findByVendorType(@Param("vendorType")String[] vendorType);
	
 }
