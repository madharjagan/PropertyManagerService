package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PropertyDao;
import com.example.demo.model.Property;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class PropertyController {
	
	@Autowired
	PropertyDao propertyDao;
	
	@GetMapping(value = "/getPropertyDetails/{propertyID}", produces = "application/json")
	public String getPropertyDetails(@PathVariable(value = "propertyID", required = true) int propertyID) {
		List<Property> listOfProperty = propertyDao.findByPropertyID(propertyID);
		
		for(Property property: listOfProperty) {
		System.out.println(property.getAddress());
		}
		Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		return objGson.toJson(listOfProperty);
	}
	
	/*@PostMapping(value = "/addProperty")
	public int addProperty(@RequestParam(value = "Address", required = true) String address, 
						   @RequestParam(value = "city", required = true) String city,
						   @RequestParam(value = "stateID", required = true) String stateID,
						   @RequestParam(value = "zipCode", required = true) String zipCode,
						   @RequestParam(value = "bedroomCount", required = true) int bedroomCount,
						   @RequestParam(value = "bathroomCount", required = true) int bathroomCount,
						   @RequestParam(value = "createDate", required = true) Date createDate,
						   @RequestParam(value = "lastUpdateDate", required = true) Date lastUpdateDate,
						   @RequestParam(value = "notes", required = true) String notes,
						   @RequestParam(value = "sqFootage", required = true) int sqFootage
						   ) {
		
		
		Property property = new Property();
		property.setAddress(address);
		property.setCity(city);
		property.setStateID(stateID);
		property.setZipCode(zipCode);
		property.setBedroomCount(bedroomCount);
		property.setBathroomCount(bathroomCount);
		property.setCreateDate(createDate);
		property.setLastUpdateDate(lastUpdateDate);
		property.setNotes(notes);
		property.setSqFootage(sqFootage);
		
		propertyDao.save(property);
	
		return 0;
	}*/
	
	
	@PostMapping(value = "/addProperty")
	public Property addProperty(@RequestBody Property property) {	
		System.out.print("property.getAddress() ################################" + property.getCreateDate());
		return propertyDao.save(property);
	}
	

}
