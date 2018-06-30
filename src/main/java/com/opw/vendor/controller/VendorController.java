/*package com.opw.vendor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opw.vendor.dao.VendorDao;
import com.opw.vendor.model.VendorTypes;
import com.opw.vendor.vo.Response;
import com.opw.vendor.vo.VendorResponse;
import com.opw.vendor.vo.VendorTypeVo;

@CrossOrigin(origins = "*")
@RestController
public class VendorController {
	
	@Autowired
	VendorDao vendorDao;
	
	
	
	@GetMapping(value = "/getVendorDetails", produces = "application/json")
	public Response getVendorDetails() {
		List<VendorTypeVo> listOfProperty = vendorDao.findVendorDetails();
		Response res = new Response();
		res.setResult(listOfProperty);
		res.setMessage("Success");
		return res;
	}
	
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
	public Response getVendorDetailsForType(@RequestParam(value = "vendorType", required = true)String[] vendorType) {
		List<VendorTypeVo> listOfProperty = vendorDao.findVendorDetailsForType(vendorType);
		Map<String, List<VendorTypeVo>> resMap = new HashMap<>(); 
		resMap.put("vendortypes", listOfProperty);
		Response res = new Response();
		res.setResult(resMap);
		res.setMessage("Success");
		return res;
	}
	
	@GetMapping(value = "/getVendorDetailsForType1", produces = "application/json")
	public Map<String, List<VendorTypeVo>> getVendorDetailsForType1(@RequestParam(value = "vendorType", required = true)String[] vendorType) {
		List<VendorTypeVo> listOfProperty = vendorDao.findVendorDetailsForType(vendorType);
		Map<String, List<VendorTypeVo>> resMap = new HashMap<>(); 
		resMap.put("vendortypes", listOfProperty);
		//Response res = new Response();
		//res.setVendortypes(listOfProperty);
		//res.setMessage("Success");
		return resMap;
	}
	
	@GetMapping(value = "/getVendorDetailByType", produces = "application/json")
	public Response getAllPropertyDetails(@RequestParam(value = "vendorType", required = true)String[] vendorType) {
		List<String[]> listOfProperty = vendorDao.findByVendorType(vendorType);
		Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		Response res = new Response();
		res.setStatus("Success");
		res.setResult(objGson.toJson(listOfProperty));
		return res;
	}
	
	
	@GetMapping(value = "/getVendorDetailByType", produces = "application/json")
	public Response getAllPropertyDetails(@RequestParam(value = "vendorType", required = true)String[] vendorType) {
		List<String[]> listOfProperty = vendorDao.findByVendorType(vendorType);
		List<VendorResponse> reslist = new ArrayList<>();
		for(Object[] temp : listOfProperty){
			VendorResponse vr = new VendorResponse();
			vr.setVendorName(temp[0].toString());
			vr.setVendorType(temp[1].toString());
			reslist.add(vr);
		}
		
		Map<String , List<String>> test = new HashMap<>();
		List<String> name = new ArrayList<>();
		for (String ven : vendorType) {
			for (Object[] temp : listOfProperty) {
				if (ven.equalsIgnoreCase(temp[1].toString())) {
					name.add(temp[0].toString());
				}
				test.put(temp[1].toString(), name);
			}
		}
		
		
		Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		Response res = new Response();
		res.setStatus("Success");
		res.setResult(objGson.toJson(test));
		return res;
	}
	
}
*/




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
		List<VendorTypeVo> listOfProperty = vendorDao.findVendorDetailsForType(vendorType);
		Map<String, List<VendorTypeVo>> resMap = new HashMap<>(); 
		resMap.put("vendortypes", listOfProperty);
		return resMap;
	}
	
}
