/**
 * 
 */
package com.example.employee.service;

import java.util.List;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.exception.EmployeeException;

/**
 * Provide service call related to employee.
 * 
 * @author Salman
 *
 */
public interface IEmployeeService {

	/**
	 * Create new employee.
	 * 
	 * @param employeeDTO
	 * @throws EmployeeException
	 */
	public void createEmployee(EmployeeDTO employeeDTO) throws EmployeeException;

	/**
	 * List of employees.
	 * 
	 * @throws EmployeeException
	 */
	public List<EmployeeDTO> listAllEmployess() throws EmployeeException;

	/**
	 * Find Employee by name.
	 * 
	 * @param employeeName
	 * @return
	 * @throws EmployeeNotFoundException
	 */

	public EmployeeDTO findEmployeeByName(String employeeName) throws EmployeeNotFoundException;
	
	public EmployeeDTO findEmployeeByAddress(String address) throws EmployeeNotFoundException;
}
