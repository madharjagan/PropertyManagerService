package com.opw.vendor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the property database table.
 * Child Table - Vendor
 * 
 */
@Entity
@Table(name="Vendor")
@NamedQuery(name="Vendor.findAll", query="SELECT v FROM Vendor v")
public class Vendor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vendorId;
	private String vendorName;
	private String address;
	private String services;
	private String phone;
	private String email;
	
	
	@ManyToOne
	@JoinColumn(name="vendortypeId", referencedColumnName="vendortypeId")
    private VendorTypes vendorType;

	public Vendor() {
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * @return the vendorId
	 */
	public final int getVendorId() {
		return vendorId;
	}


	/**
	 * @param vendorId the vendorId to set
	 */
	public final void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}


	/**
	 * @return the address
	 */
	public final String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public final void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the services
	 */
	public final String getServices() {
		return services;
	}


	/**
	 * @param services the services to set
	 */
	public final void setServices(String services) {
		this.services = services;
	}


	/**
	 * @return the phone
	 */
	public final String getPhone() {
		return phone;
	}


	/**
	 * @param phone the phone to set
	 */
	public final void setPhone(String phone) {
		this.phone = phone;
	}


	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the vendorName
	 */
	public final String getVendorName() {
		return vendorName;
	}


	/**
	 * @param vendorName the vendorName to set
	 */
	public final void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	/**
	 * @return the vendorType
	 */
	public final VendorTypes getVendorType() {
		return vendorType;
	}


	/**
	 * @param vendorType the vendorType to set
	 */
	public final void setVendorType(VendorTypes vendorType) {
		this.vendorType = vendorType;
	}


	
}