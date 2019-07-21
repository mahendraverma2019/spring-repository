package com.persistence.test.spring;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.persistence.test.spring.configuration.AppConfig;
import com.persistence.test.spring.dao.EmployeeDaoJdbcTemplate;
import com.persistence.test.spring.model.Employee;

public class AppMainJdbcTemplate {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Save Employee using JdbcTemplate
	    EmployeeDaoJdbcTemplate dao=(EmployeeDaoJdbcTemplate)context.getBean(EmployeeDaoJdbcTemplate.class);  
	    Employee e3 =  new Employee();
	    e3.setId(3);
	    e3.setJoiningDate(new LocalDate(2012, 11, 12));
	    e3.setName("Amit");
	    e3.setSalary(new BigDecimal(20000));
	    e3.setSsn("435465546");
	    int status=dao.saveEmployee(e3);  
	    System.out.println(status);	
	    context.close();
	}	

}
