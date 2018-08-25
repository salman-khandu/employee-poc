/**
 * 
 */
package com.example.employee.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.address.model.Address;
import com.example.employee.model.Employee;

/**
 * Building employee model
 * 
 * @author Salman
 *
 */
@Component
@Scope("prototype")
public class EmployeeBuilder {

	private String name;
	private Long id;
	private Address address;

	public EmployeeBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public EmployeeBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public EmployeeBuilder withAddress(Address address) {
		this.address = address;
		return this;
	}

	public Employee build() {
		return new Employee(id, name ,address);
	}

}
