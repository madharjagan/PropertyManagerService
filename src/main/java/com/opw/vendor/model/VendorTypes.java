package com.opw.vendor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Parent Table - VendorType.
 * 
 */
@Entity
@Table(name="VendorTypes")
@NamedQuery(name="VendorTypes.findAll", query="SELECT v FROM VendorTypes v")
public class VendorTypes implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vendortypeId")
	private Integer vendortypeId;
	
	private String vendorType;

    @OneToMany(cascade = {CascadeType.ALL},mappedBy="vendorType")
	private List<Vendor> vendor;

	
	/**
	 * @return the vendortypeId
	 */
	public final int getVendortypeId() {
		return vendortypeId;
	}

	/**
	 * @param vendortypeId the vendortypeId to set
	 */
	public final void setVendortypeId(int vendortypeId) {
		this.vendortypeId = vendortypeId;
	}

	/**
	 * @return the vendorType
	 */
	public final String getVendorType() {
		return vendorType;
	}

	/**
	 * @param vendorType the vendorType to set
	 */
	public final void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	/**
	 * @return the vendor
	 */
	public final List<Vendor> getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public final void setVendor(List<Vendor> vendor) {
		this.vendor = vendor;
	}

}