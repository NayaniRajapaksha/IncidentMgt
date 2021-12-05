package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.Vendor;

public interface EmployeeDAO {
	public List<Employee> getEmployeeByEmpId(String empId);
	
	public Employee getEmployeeById(int id);
}
