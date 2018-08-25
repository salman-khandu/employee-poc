/**
 * 
 */
package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.model.Employee;

/**
 * Represent Repository layer of employee
 * 
 * @author salman
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	public Employee findByName(String name);
	
	public Employee findByAddressAddress(String address);

}
