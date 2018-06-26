package com.opw.property.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opw.property.dao.PropertyDao;
import com.opw.property.model.Property;

@CrossOrigin(origins = "*")
@RestController
public class PropertyController {
	
	@Autowired
	PropertyDao propertyDao;
	
	@GetMapping(value = "/getPropertyDetails/{propertyID}", produces = "application/json")
	public Property getPropertyDetails(@PathVariable(value = "propertyID", required = true) int propertyID) {
		Property property = propertyDao.findByPropertyID(propertyID);
		//Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		return property;
	}
	
	@GetMapping(value = "/getPropertyDetails", produces = "application/json")
	public List<Property> getAllPropertyDetails() {
		List<Property> listOfProperty = propertyDao.findAll();
		
		for(Property property: listOfProperty) {
			System.out.println("GETGETGETGET"+property.getStreet_number());
			System.out.println("GETGETGETGET"+property.getRoute());
		}
	//	Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		return listOfProperty;
	}
	
	@PostMapping(value = "/addProperty")
	public Property addProperty(@RequestBody Property property) {
		System.out.println("*********************"+property.getStreet_number());
		System.out.println("*********************"+property.getRoute());
		System.out.println("*********************"+property.getBathroomCount());
		return propertyDao.save(property);
	}
	
	/*@DeleteMapping("/removeProperty/{propertyID}")
	public void deleteStudent(@PathVariable(value = "propertyID", required = true) int propertyID) {
		studentRepository.deleteById(id);
	}*/

}
