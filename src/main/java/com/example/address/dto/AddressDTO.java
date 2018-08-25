/**
 * 
 */
package com.example.address.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Represent Data Transfer Object of Address.
 * 
 * @author Salman
 *
 */
public class AddressDTO {

	@NotBlank
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
