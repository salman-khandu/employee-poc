/**
 * 
 */
package com.example.employee.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.address.model.Address;

/**
 * Represent model of employee.
 * 
 * @author Salman
 *
 */
@Entity
@Table(name = "T_EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	public Employee() {
	}

	public Employee(Long id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
