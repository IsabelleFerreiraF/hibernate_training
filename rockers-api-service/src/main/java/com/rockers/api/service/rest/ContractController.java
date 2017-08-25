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

import com.rockers.api.model.Contract;
import com.rockers.api.repository.ContractRepository;

@RestController
@RequestMapping(value="/contract")
public class ContractController {
		
	@Autowired
	private ContractRepository contractRepository;
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Long> saveContract(@RequestBody Contract contract)
	{
		contractRepository.save(contract);
		return new ResponseEntity<Long>(contract.getId(),HttpStatus.OK);
	}
	
	@RequestMapping (method=RequestMethod.DELETE)
	public void deleteContract(@PathVariable Long id){
		contractRepository.delete(id);
	}

	@RequestMapping (method=RequestMethod.GET, value = "/listAll")
	public ResponseEntity<List<Contract>> listAll(){
		List<Contract> list = contractRepository.findAll();
		return new ResponseEntity<List<Contract>>(list,HttpStatus.OK);
	}
	
	@RequestMapping (method=RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Contract> findOne(@PathVariable Long id){
		Contract contract = contractRepository.findOne(id);
		return new ResponseEntity<Contract>(contract,HttpStatus.OK);
	}
	
	@RequestMapping (method=RequestMethod.PUT)
	public ResponseEntity<Long> updateContract(@RequestBody Contract contract){
		contractRepository.save(contract);
		return new ResponseEntity<Long>(contract.getId(),HttpStatus.OK);
	}
	
}
