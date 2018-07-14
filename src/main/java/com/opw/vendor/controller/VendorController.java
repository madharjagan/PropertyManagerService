package com.opw.vendor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opw.vendor.dao.VendorDao;
import com.opw.vendor.model.VendorTypes;
import com.opw.vendor.vo.VendorResponse;
import com.opw.vendor.vo.VendorTypeVo;

@CrossOrigin(origins = "*")
@RestController
public class VendorController {
	
	@Autowired
	VendorDao vendorDao;
	
	
	@GetMapping(value = "/getVendorTypes", produces = "application/json")
	public  List<VendorResponse> findVendorTypes(){
		List<VendorTypes> listOfVendorTypes = vendorDao.findVendorTypes();
		List<VendorResponse> vendorRes = new ArrayList<>();
		for(VendorTypes temp:listOfVendorTypes){
			VendorResponse res = new VendorResponse();
			res.setText(temp.getVendorType());
			res.setValue(temp.getVendorType());
			vendorRes.add(res);
		}
		return vendorRes;
	}
	
	
	@GetMapping(value = "/getVendorDetailsForType", produces = "application/json")
	public Map<String, List<VendorTypeVo>> getVendorDetailsForType(@RequestParam(value = "vendorType", required = true)String[] vendorType) {
		List<VendorTypeVo> listOfVendors = vendorDao.findVendorDetailsForType(vendorType);
		Map<String, List<VendorTypeVo>> resMap = new HashMap<>(); 
		resMap.put("vendortypes", listOfVendors);
		return resMap;
	}
	
}
