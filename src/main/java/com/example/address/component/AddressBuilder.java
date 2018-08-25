/**
 * 
 */
package com.example.address.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.address.model.Address;

/**
 * Building Address model
 * 
 * @author Salman
 *
 */

@Component
@Scope("prototype")
public class AddressBuilder {

	String address;

	public AddressBuilder withAddress(String address) {
		this.address = address;
		return this;
	}
	public Address build() {
	 return new Address(address);
	}
}
