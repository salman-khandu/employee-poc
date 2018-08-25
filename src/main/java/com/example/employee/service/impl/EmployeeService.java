/**
 * 
 */
package com.example.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.address.component.AddressBuilder;
import com.example.address.dto.AddressDTO;
import com.example.address.model.Address;
import com.example.employee.component.EmployeeBuilder;
import com.example.employee.dto.EmployeeDTO;
import com.example.employee.exception.EmployeeException;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeNotFoundException;
import com.example.employee.service.IEmployeeService;

/**
 * implementation of {@link IEmployeeService}
 * 
 * @author Salman
 *
 */
@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Override
	public void createEmployee(EmployeeDTO employeeDTO) throws EmployeeException {
		AddressBuilder addressBuilder = this.applicationContext.getBean(AddressBuilder.class);
		Address address = addressBuilder.withAddress(employeeDTO.getAddress().getAddress()).build();
		EmployeeBuilder employeeBuilder = this.applicationContext.getBean(EmployeeBuilder.class);
		Employee employee = employeeBuilder.withName(employeeDTO.getName()).withAddress(address).build();
		this.employeeRepository.save(employee);
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<EmployeeDTO> listAllEmployess() throws EmployeeException {
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();
		this.employeeRepository.findAll().stream().forEach(employee -> {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employee, employeeDTO, "id");
			AddressDTO address = new AddressDTO();
			address.setAddress(employee.getAddress().getAddress());
			employeeDTO.setAddress(address);
			employeeDTOList.add(employeeDTO);
		});
		return employeeDTOList;

	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	@Override
	public EmployeeDTO findEmployeeByName(String employeeName) throws EmployeeNotFoundException {
		return checkAndReturnEmployeeIfExistOtherWiseThrowException(this.employeeRepository.findByName(employeeName));
	}

	/**
	 * Check whether employee exist otherwise throw exception.
	 * 
	 * @param employee
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	private EmployeeDTO checkAndReturnEmployeeIfExistOtherWiseThrowException(Employee employee)
			throws EmployeeNotFoundException {
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee Not fount");
		}
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employee, employeeDTO, "id");
		AddressDTO address = new AddressDTO();
		address.setAddress(employee.getAddress().getAddress());
		employeeDTO.setAddress(address);
		return employeeDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	@Override
	public EmployeeDTO findEmployeeByAddress(String address) throws EmployeeNotFoundException {
		return checkAndReturnEmployeeIfExistOtherWiseThrowException(
				this.employeeRepository.findByAddressAddress(address));
	}

}
