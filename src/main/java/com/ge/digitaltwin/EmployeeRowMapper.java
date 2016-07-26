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

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.*;

/**
 * 
 * @author predix -
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Employee mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		
		Employee employee = new Employee();
		employee.setId(resultSet.getInt("id"));
		employee.setName(resultSet.getString("name"));
		employee.setPhone(resultSet.getLong("phone"));
		employee.setSalary(resultSet.getDouble("salary"));
		
		return employee;
		
	}

}
