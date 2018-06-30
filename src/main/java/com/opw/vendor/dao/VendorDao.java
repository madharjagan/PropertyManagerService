package com.opw.vendor.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opw.vendor.model.VendorTypes;
import com.opw.vendor.repo.VendorRepo;
import com.opw.vendor.vo.VendorTypeVo;
import com.opw.vendor.vo.VendorVo;

@Repository
public class VendorDao {
	
	@Autowired
	VendorRepo vendorRepo;
	
	public List<VendorTypeVo> findVendorDetailsForType(String[] vendorType) {
		List<VendorTypes>   vendorTypeList= vendorRepo.findByVendorType(vendorType);
		List<VendorTypeVo>  vendorTypeResList = new ArrayList<>();
		vendorTypeList.forEach(vendorTypeObj ->{
			List<VendorVo>  vendorResList = new ArrayList<>();
			VendorTypeVo resVendor = new VendorTypeVo();
			resVendor.setVendortypeId(vendorTypeObj.getVendortypeId());
			resVendor.setVendorType(vendorTypeObj.getVendorType());
			vendorTypeObj.getVendor().forEach(vendor ->{
				VendorVo res = new VendorVo();
				res.setVendorName(vendor.getVendorName());
				res.setEmail(vendor.getEmail());
				res.setAddress(vendor.getAddress());
				res.setPhone(vendor.getPhone());
				res.setServices(vendor.getServices());
				res.setVendorId(vendor.getVendorId());
				vendorResList.add(res);
			});
			resVendor.setVendor(vendorResList);
			vendorTypeResList.add(resVendor);
		});
		
		return vendorTypeResList;		
	}
	
	
	
	public List<VendorTypes> findVendorTypes(){
		return vendorRepo.findAll();
	}

}
