package com.rockers.api.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rockers.api.model.Employee;
import com.rockers.api.repository.EmployeeRepository;

@RestController
@RequestMapping(value="/{employee}")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Long> saveEmployee(@RequestBody Employee employee){
		 employeeRepository.save(employee);
		return new ResponseEntity<Long>(employee.getId(),HttpStatus.OK);
	}
	
	@RequestMapping (method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable Long id){
		employeeRepository.delete(id);
	}

	@RequestMapping (method=RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAll(){
		List<Employee> list = employeeRepository.findAll();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	
	@RequestMapping (method=RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Employee> findOne(@PathVariable Long id){
		Employee employee = employeeRepository.findOne(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@RequestMapping (method=RequestMethod.PUT)
	public ResponseEntity<Long> updateEmployee(@RequestBody Employee employee){
		 employeeRepository.save(employee);
		return new ResponseEntity<Long>(employee.getId(),HttpStatus.OK);
	}
	
}
