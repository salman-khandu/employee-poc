/**
 * 
 */
package com.example.employee.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.exception.EmployeeException;
import com.example.employee.service.EmployeeNotFoundException;
import com.example.employee.service.IEmployeeService;

/**
 * Exposes rest end-point related to employee.
 * 
 * @author Salman
 *
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	/**
	 * Create new employee
	 * 
	 * @param employeeDTO
	 * @throws EmployeeException
	 */
	@PostMapping("/employee")
	public void createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) throws EmployeeException {
		this.employeeService.createEmployee(employeeDTO);
	}

	/**
	 * Get All Employees.
	 * 
	 * @return
	 * @throws EmployeeException
	 */
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDTO>> listAllEmployees() throws EmployeeException {
		List<EmployeeDTO> employess = this.employeeService.listAllEmployess();
		if (employess.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmployeeDTO>>(employess, HttpStatus.OK);
	}

	/**
	 * Get Employee by employee name.
	 * 
	 * @param employeeName
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@GetMapping("/find-employees-by-name")
	public ResponseEntity<EmployeeDTO> findByEmployeeName(@RequestParam String employeeName)
			throws EmployeeNotFoundException {
		return new ResponseEntity<EmployeeDTO>(this.employeeService.findEmployeeByName(employeeName), HttpStatus.OK);

	}

	/**
	 * Get Employee by address
	 * 
	 * @param address
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@GetMapping("/find-employees-by-address")
	public ResponseEntity<EmployeeDTO> findByEmployeeAddress(@RequestParam String address)
			throws EmployeeNotFoundException {
		return new ResponseEntity<EmployeeDTO>(this.employeeService.findEmployeeByAddress(address), HttpStatus.OK);

	}

}
