package org.employeemanagement.dao;

import java.util.List;

import org.employeemanagement.pojo.Employee;

public interface EmployeeDAOInterface {

	//adding an employee
	Employee addEmployee(Employee employee);

	Employee updateEmployee(Employee emp);

	List<Employee> listEmployee();

	void removeEmployee(int id);
	 
	Employee getEmployee2(int id);

}