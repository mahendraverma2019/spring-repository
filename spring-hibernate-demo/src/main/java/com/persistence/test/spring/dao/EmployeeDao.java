package com.persistence.test.spring.dao;

import java.util.List;

import com.persistence.test.spring.model.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee employee);
	
	void persistEmployee(Employee employee);
	
	List<Employee> findAllEmployees();
	
	void deleteEmployeeBySsn(String ssn);
	
	Employee findBySsn(String ssn);
	
	void updateEmployee(Employee employee);
}
