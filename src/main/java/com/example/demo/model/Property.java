package com.example.demo.model;

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

	private String address;

	private int bathroomCount;

	private int bedroomCount;

	private String city;

	@Temporal(TemporalType.TIMESTAMP)
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS") 
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private Date lastUpdateDate;

	private String notes;

	private int sqFootage;

	private String stateID;

	private String zipCode;

	public Property() {
	}

	public int getPropertyID() {
		return this.propertyID;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBathroomCount() {
		return this.bathroomCount;
	}

	public void setBathroomCount(int bathroomCount) {
		this.bathroomCount = bathroomCount;
	}

	public int getBedroomCount() {
		return this.bedroomCount;
	}

	public void setBedroomCount(int bedroomCount) {
		this.bedroomCount = bedroomCount;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getSqFootage() {
		return this.sqFootage;
	}

	public void setSqFootage(int sqFootage) {
		this.sqFootage = sqFootage;
	}

	public String getStateID() {
		return this.stateID;
	}

	public void setStateID(String stateID) {
		this.stateID = stateID;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}