package com.rockers.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockers.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
