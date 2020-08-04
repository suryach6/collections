package com.cg.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.beans.Employee;

public class Dao implements IDao{
	List<Employee> emp = new ArrayList<Employee>();
	@Override
	public void createEmployee(Employee empl) {
		emp.add(empl);
		System.out.println("Employee is created");		
	}
	public List<Employee> getEmployees() {
		return emp;
	}
}
