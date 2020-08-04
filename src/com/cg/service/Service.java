package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.beans.Employee;
import com.cg.dao.Dao;
import com.cg.dao.IDao;

public class Service implements IService{
	
	IDao dao;
	public Service() {
		dao = new Dao();
	}

	@Override
	public boolean validateEmpId(String empId) {
		String regex = "^[0-9]{5}_[A-Z]{2}$";
		return empId.matches(regex);
	}
	@Override
	public boolean validatefName(String firstname) {
		return firstname.matches("^[A-Za-z]{3,}$");
	}
    @Override
    public boolean validateSName(String secondname) {
	return secondname.matches("^[A-Za-z]{3,}$");
    }


	@Override
	public boolean validateSalary(double sal) {
		return (sal>=20000 && sal<= 500000);
	}


	@Override
	public boolean vaidateJoinDate(LocalDate date) {
		int flag = date.compareTo(LocalDate.now());
		return (flag>=0);
	}

	@Override
	public void createEmployee(Employee empl) {
		dao.createEmployee(empl);
		
	}
	public List<Employee> getEmployees(){
		return dao.getEmployees();
	}

}
