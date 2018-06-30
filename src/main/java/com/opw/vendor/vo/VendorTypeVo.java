package com.opw.vendor.vo;

import java.util.List;

public class VendorTypeVo {
		
	/** The vendortype id. */
	private int vendortypeId;
	
	/** The vendor type. */
	private String vendorType;

	/** The vendor. */
	private List<VendorVo> vendor;
	
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
	public final List<VendorVo> getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public final void setVendor(List<VendorVo> vendor) {
		this.vendor = vendor;
	}

}
