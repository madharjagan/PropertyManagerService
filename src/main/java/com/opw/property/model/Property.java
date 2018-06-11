package com.opw.property.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * The persistent class for the property database table.
 * 
 */
@Entity
@NamedQuery(name="Property.findAll", query="SELECT p FROM Property p")
public class Property implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int propertyID;

	private String street_number;
	private String route;
	private String locality;
	private String administrative_area_level_1;
	private String country;
	private String postal_code;
	
	private String propertytype;
	private int lotsize;
	private int sqfootage;
	private int yearbuilt;
	private int bedroomCount;
	private int bathroomCount;
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS") 
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private Date lastUpdateDate;

	public Property() {
	}

	public int getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getAdministrative_area_level_1() {
		return administrative_area_level_1;
	}

	public void setAdministrative_area_level_1(String administrative_area_level_1) {
		this.administrative_area_level_1 = administrative_area_level_1;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getPropertytype() {
		return propertytype;
	}

	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}

	public int getLotsize() {
		return lotsize;
	}

	public void setLotsize(int lotsize) {
		this.lotsize = lotsize;
	}

	public int getSqfootage() {
		return sqfootage;
	}

	public void setSqfootage(int sqfootage) {
		this.sqfootage = sqfootage;
	}

	public int getYearbuilt() {
		return yearbuilt;
	}

	public void setYearbuilt(int yearbuilt) {
		this.yearbuilt = yearbuilt;
	}

	public int getBedroomCount() {
		return bedroomCount;
	}

	public void setBedroomCount(int bedroomCount) {
		this.bedroomCount = bedroomCount;
	}

	public int getBathroomCount() {
		return bathroomCount;
	}

	public void setBathroomCount(int bathroomCount) {
		this.bathroomCount = bathroomCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}