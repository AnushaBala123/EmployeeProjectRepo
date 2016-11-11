package org.employeemanagement.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.employeemanagement.dao.EmployeeDAOInterface;
import org.employeemanagement.pojo.Employee;
import org.junit.Before;
import org.junit.Test;

public class EmployeeServiceTest {

	private EmployeeService employeeService;

	private EmployeeDAOInterface employeeDaoInterface;

	@Before
	public void setUp() {
		employeeService = new EmployeeService();
		employeeDaoInterface = mock(EmployeeDAOInterface.class);
		employeeService.setEmployeeDAOInterface(employeeDaoInterface);

	}

	

	@Test
	public void testaddingEmployee() {
		Employee sampleEmployee=new Employee();
		
		
	    employeeService.addEmployee(sampleEmployee);
	    verify(employeeDaoInterface).addEmployee(sampleEmployee);
	}
	
	@Test
	public void testUpdateEmployee() {
		Employee sampleEmployee=new Employee();
		 employeeService.updateEmployee(sampleEmployee);
	    verify(employeeDaoInterface,times(1)).updateEmployee(sampleEmployee);
	}
	
	@Test
	public void testListEmployee() {
		//Employee sampleEmployee=new Employee();
		 employeeService.listEmployee();
	    verify(employeeDaoInterface,times(1)).listEmployee();
	}
	
	
	@Test 
	public void testRemoveEmployee() {
		
		employeeService.setEmployeeDAOInterface(employeeDaoInterface);
		Employee employee =new Employee();
		employeeService.removeEmployee(employee.getId());
		verify(employeeDaoInterface,times(1)).removeEmployee(employee.getId());
		
	}

	
}
