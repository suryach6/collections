package com.cg.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.cg.beans.Address;
import com.cg.beans.Department;
import com.cg.beans.Employee;
import com.cg.service.IService;
import com.cg.service.Service;

public class Main {

	public static void main(String[] args) {
		IService service = new Service();
		Employee employee = null;
		Department department = null;
		List<Address> address = null;
		Scanner sc = new Scanner(System.in); 
		
		while(true) {
			System.out.println("1. To create an Employee");
			System.out.println("2. Sort By Employee ID");
			System.out.println("3. Sort By First Name");
			System.out.println("4. Sort By second Name");
			System.out.println("5. Sort By Salary");
			System.out.println("6. Sort By Address");
			System.out.println("7. Sort By Department");
			System.out.println("8. Exit");
			
			switch(sc.nextInt()) {
			case 1 :
				System.out.println("Enter employee id : ");
				String empId = sc.next();
				if(service.validateEmpId(empId)) {
					employee = new Employee();
					employee.setEmpId(empId);
				}else {
					System.out.println("Invalid format of employee Id!!!");
					break;
				}
				System.out.println("Enter First name : ");
				String fname = sc.next();
				if(service.validatefName(fname)) {
					employee.setFirstName(fname);
				}else {
					System.out.println("Error!!! enter valid format of First Name ");
					break;
				}
				System.out.println("Enter second Name : ");
				String lname = sc.next();
				if(service.validateSName(lname)) {
					employee.setLastName(lname);
				}else {
					System.out.println("Error!!! enter valid format of Last Name ");
					break;
				}
				System.out.println("Enter salary (must be in range of 20000 to 500000) : ");
				double sal = sc.nextDouble();
				if(service.validateSalary(sal)) {
					employee.setSalary(sal);
				}else {
					System.out.println("Error!!! Salary is not in valid range");
					break;
				}
				System.out.println("Enter joining date (must be 'yyyy-MM-dd' format): ");
				String joinDate =  sc.next();
				LocalDate date = LocalDate.parse(joinDate);
				if(service.vaidateJoinDate(date)) {
					employee.setDateOfJoin(date);
				}else {
					System.out.println("Error!! joiing date should be today/future date...");
					break;
				}
				department = new Department();
				System.out.println("Enter department Id : ");
				int deptId = sc.nextInt();
				department.setDeptId(deptId);
				System.out.println("Enter department name : ");
				department.setDeptName(sc.next());
				System.out.println("Enter location : ");
				department.setLocation(sc.next());
				
				employee.setDepartment(department);
				
				System.out.println("Enter the no. of address");
				int n = sc.nextInt();
				address = new ArrayList<Address>(n);
				for(int i=0;i<n;i++) {
					Address add = new Address();
					System.out.println("Enter address Id : ");
					add.setAddressId(sc.nextInt());
					System.out.println("Enter address line1 : ");
					add.setAddressLine1(sc.next());
					System.out.println("Enter city : ");
					add.setCity(sc.next());
					System.out.println("Enter state : ");
					add.setState(sc.next());
					address.add(add);
				}
				employee.setAddress(address);
				service.createEmployee(employee);
				break;
				
			case 2 : 
					System.out.println("Sort By EmployeeId in ascending order :");
					Comparator<Employee> sortById = new Comparator<Employee>() {
						
						@Override
						public int compare(Employee o1, Employee o2) {
							return o1.getEmpId().compareTo(o2.getEmpId());
						}
					};
					Collections.sort(service.getEmployees(),sortById);
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					break;
			case 3 :
					System.out.println("Sort By Employee First Name in ascending order :");
					Comparator<Employee> sortByName = new Comparator<Employee>() {
						
						@Override
						public int compare(Employee o1, Employee o2) {
							return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
						}
					};
					Collections.sort(service.getEmployees(),sortByName);
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					break;
			case 4 : 
					System.out.println("Sort By Employee Last Name in ascending order :");
					Comparator<Employee> sortByLastName = new Comparator<Employee>() {
					
						@Override
						public int compare(Employee o1, Employee o2) {
							return o1.getLastName().compareToIgnoreCase(o2.getLastName());
						}
					};
					Collections.sort(service.getEmployees(),sortByLastName);
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					break;
			
			case 5 : 
					System.out.println("Sort By Salary in descending order : ");
					Comparator<Employee> sortBySal = new Comparator<Employee>() {
						public int compare(Employee o1, Employee o2) {
							if(o1.getSalary()<o2.getSalary())
								return 1;
							else if(o1.getSalary()>o2.getSalary())
								return -1;
							else
								return 0;
						}
					};
					Collections.sort(service.getEmployees(), sortBySal);
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					break;
			case 6 : 
					System.out.println("Sort By Address : ");
					for(Employee e : service.getEmployees()) {
						Collections.sort(  e.getAddress(),new Comparator<Address>(){
							public int compare(Address a1,Address a2) {
								return a1.getAddressId()-a2.getAddressId();
							}
						} 
						);
					}
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					break;
			
			case 7 :
					System.out.println("Sort By Department Id in ascending order :");
					Comparator<Employee> sortByDeptId = new Comparator<Employee>() {
						@Override
						public int compare(Employee o1, Employee o2) {
							return o1.getDepartment().getDeptId()-o2.getDepartment().getDeptId();
						}
					};
					Collections.sort(service.getEmployees(), sortByDeptId);
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					
					System.out.println("Sort By Department Name in ascending order :");
					Comparator<Employee> sortByDeptName = new Comparator<Employee>() {
						@Override
						public int compare(Employee o1, Employee o2) {
							return o1.getDepartment().getDeptName().compareToIgnoreCase(o2.getDepartment().getDeptName());
						}
					};
					Collections.sort(service.getEmployees(), sortByDeptName);
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					break;
			
			case 8 : 
					System.out.println("Thank You.");break;
			}		
		}
		

	}

}
