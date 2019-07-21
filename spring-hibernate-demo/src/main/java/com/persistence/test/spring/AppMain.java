package com.persistence.test.spring;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.persistence.test.spring.configuration.AppConfig;
import com.persistence.test.spring.model.Employee;
import com.persistence.test.spring.service.EmployeeService;

public class AppMain {

	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		EmployeeService service = (EmployeeService) context.getBean("employeeService");

		/*
		 * Create Employee1
		 */
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setName("Sam Tully");
		employee1.setJoiningDate(new LocalDate(2010, 10, 10));
		employee1.setSalary(new BigDecimal(10000));
		employee1.setSsn("134567899");

		/*
		 * Create Employee2
		 */
		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("Rober Baratheon");
		employee2.setJoiningDate(new LocalDate(2012, 11, 11));
		employee2.setSalary(new BigDecimal(20000));
		employee2.setSsn("5554657657");

		/*
		 * Persist both Employees
		 */
		service.saveEmployee(employee1);
		service.saveEmployee(employee2);

		/*
		 * Get all employees list from database
		 */
		List<Employee> employees = service.findAllEmployees();
		for (Employee emp : employees) {
			System.out.println(emp);
		}

		/*
		 * delete an employee
		 */
		service.deleteEmployeeBySsn("5554657657");

		/*
		 * update an employee
		 */

		Employee employee = service.findBySsn("134567899");
		employee.setSalary(new BigDecimal(2000));
		service.updateEmployee(employee);

		/*
		 * Get all employees list from database
		 */
		List<Employee> employeeList = service.findAllEmployees();
		for (Employee emp : employeeList) {
			System.out.println(emp);
		}		    
	    
		context.close();

	}
}
