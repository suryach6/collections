package com.cg.dao;

import java.util.List;

import com.cg.beans.Employee;

public interface IDao {
	public void createEmployee(Employee empl);
	public List<Employee> getEmployees();
}
