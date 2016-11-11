package org.employeemanagement.service;

import java.util.List;

import org.employeemanagement.dao.EmployeeDAOInterface;
import org.employeemanagement.pojo.Employee;

public interface EmployeeServiceInterface {

	void setEmployeeDAOInterface(EmployeeDAOInterface dao);

	void addEmployee(Employee e);

	Employee updateEmployee(Employee emp);

	List<Employee> listEmployee();

	void removeEmployee(int id);
	Employee getEmployee2(int id);

}