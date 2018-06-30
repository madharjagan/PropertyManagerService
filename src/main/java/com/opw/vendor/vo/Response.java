package com.opw.vendor.vo;

import java.util.List;

import com.opw.vendor.model.Vendor;

public class Response {

	private Object result;
	
	private String message;

	private Object vendortypes;
	/**
	

	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the result
	 */
	public final Object getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public final void setResult(Object result) {
		this.result = result;
	}

	/**
	 * @return the vendortypes
	 */
	public final Object getVendortypes() {
		return vendortypes;
	}

	/**
	 * @param vendortypes the vendortypes to set
	 */
	public final void setVendortypes(Object vendortypes) {
		this.vendortypes = vendortypes;
	}
}
