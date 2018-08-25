/**
 * 
 */
package com.example.employee.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.example.address.dto.AddressDTO;

/**
 * Represent Data Transfer Object of Employee.
 * 
 * @author Salman
 *
 */
public class EmployeeDTO {

	@NotBlank
	private String name;
	
	@NotNull
	@Valid
	private AddressDTO address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

}
