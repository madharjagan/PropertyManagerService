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
	
	@PostMapping(value = "/addProperty")
	public Property addProperty(@RequestBody Property property) {
		return propertyDao.save(property);
	}
	

}
