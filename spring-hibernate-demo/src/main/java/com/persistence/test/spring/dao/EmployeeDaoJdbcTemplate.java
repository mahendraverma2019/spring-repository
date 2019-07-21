package com.persistence.test.spring.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.persistence.test.spring.model.Employee;

@Component
public class EmployeeDaoJdbcTemplate {
		
		private DataSource dataSource = dataSource();
		
		private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		  
		public int saveEmployee(Employee e){  
		    String query="insert into employee values("+e.getId()+","+e.getJoiningDate()+",'"+e.getName()+"',"+e.getSalary()+",'"+e.getSsn()+"')";  
		    return jdbcTemplate.update(query);  
		}  
		public int updateEmployee(Employee e){  
		    String query="update employee set name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";  
		    return jdbcTemplate.update(query);  
		}  
		public int deleteEmployee(Employee e){  
		    String query="delete from employee where id='"+e.getId()+"' ";  
		    return jdbcTemplate.update(query);  
		}  
		
		@Bean
		public DataSource dataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUrl("jdbc:postgresql://localhost:5432/testdb");
			dataSource.setUsername("postgres");
			dataSource.setPassword("password");
			return dataSource;
		}
}
