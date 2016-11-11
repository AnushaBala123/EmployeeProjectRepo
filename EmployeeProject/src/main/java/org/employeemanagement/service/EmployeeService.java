package org.employeemanagement.service;

import java.util.List;

import org.employeemanagement.dao.EmployeeDAOInterface;
import org.employeemanagement.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	@Autowired
	private EmployeeDAOInterface dao;
	


public void setEmployeeDAOInterface(EmployeeDAOInterface dao){
	this.dao=dao;
}

public void addEmployee(Employee e){
	this.dao.addEmployee(e);
}

public Employee getEmployee2(int id){
	return this.dao.getEmployee2(id);
}

public Employee updateEmployee(Employee emp){
	return this.dao.updateEmployee(emp);
}

public List<Employee> listEmployee(){
	return this.dao.listEmployee();
}


public void removeEmployee(int id) {
this.dao.removeEmployee(id);
}
}