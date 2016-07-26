/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.ge.digitaltwin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author predix -
 */
@SpringBootApplication
@RestController
public class EmployeeController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/fetchEmployee")
	public List<Employee> fetchEmployee() {
		
		String sql="SELECT \"id\",\"name\",\"phone\",\"salary\" FROM \"public\".\"Employee\"";
		
		return jdbcTemplate.query(sql, new EmployeeRowMapper());
	}
	
	@RequestMapping("/saveEmployee")
	public int saveEmployee() {
		String sql = "INSERT INTO \"public\".\"Employee\" (\"id\",\"name\",\"phone\",\"salary\") VALUES (103, 'Sathish', 9008, 40000.00)";
		
		return jdbcTemplate.update(sql);
	}
	
	@RequestMapping("/updateEmployee")
	public int updateEmployee() {
		String sql = "UPDATE \"public\".\"Employee\" set \"salary\"= 30000 WHERE \"id\"= 101";
		
		return jdbcTemplate.update(sql);
	}
	
	@RequestMapping("/deleteEmployee")
	public int deleteEmployee() {
		String sql = "DELETE FROM \"public\".\"Employee\" WHERE \"id\"= 101";
		
		return jdbcTemplate.update(sql);
	}
	
	public static void main(String[] args)
    {
		
        SpringApplication.run(EmployeeController.class, args);
    }
	
}
