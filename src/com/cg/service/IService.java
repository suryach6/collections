package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.beans.Employee;

public interface IService {
	public boolean validateEmpId(String empId);
	public boolean validateSalary(double sal);
	public boolean validatefName(String firstname);
	public boolean validateSName(String secondname);
	public boolean vaidateJoinDate(LocalDate date);
	
	public void createEmployee(Employee empl);
	public List<Employee> getEmployees();

}
