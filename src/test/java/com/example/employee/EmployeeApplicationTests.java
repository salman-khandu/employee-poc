package com.example.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.address.dto.AddressDTO;
import com.example.employee.dto.EmployeeDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createEmployeeWithSuccess() {
		
		EmployeeDTO emp = new EmployeeDTO();
		AddressDTO address = new AddressDTO();
		address.setAddress("3/318/17 Mohammadi mohalla");
		emp.setName("Salman");
		emp.setAddress(address);
		HttpEntity<EmployeeDTO> request = new HttpEntity<>(emp);
		ResponseEntity<Void> responseEntity = this.restTemplate
				.exchange("http://localhost:" + port + "/emp/api/v1/employee", HttpMethod.POST, request, Void.class);
		assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
	}
	
	@Test
	public void createEmployeeWithErrorCase() {
		
		EmployeeDTO emp = new EmployeeDTO();
		AddressDTO address = new AddressDTO();
		address.setAddress(null);
		emp.setName("Salman");
		emp.setAddress(address);
		HttpEntity<EmployeeDTO> request = new HttpEntity<>(emp);
		ResponseEntity<Void> responseEntity = this.restTemplate
				.exchange("http://localhost:" + port + "/emp/api/v1/employee", HttpMethod.POST, request, Void.class);
		assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
		responseEntity.getHeaders();
	}
	
	
	

}
