package com.opw.client.vo;

import java.util.List;

import com.opw.property.model.Property;

/**
 * POJO class for Client.
 * 
 */
public class ClientVo {

	private int clientID;
	private String clientname;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private List<PropertyVo> property;

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the property
	 */
	public final List<PropertyVo> getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public final void setProperty(List<PropertyVo> property) {
		this.property = property;
	}

	

}