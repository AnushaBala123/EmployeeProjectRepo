package org.employeemanagement.controller;

import java.util.List;

import org.employeemanagement.pojo.Employee;
import org.employeemanagement.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeService;


	@RequestMapping(produces = "application/json", value = "/listjson", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> listEmployees() {
		// model.addAttribute("employee", new Employee());
		ModelAndView model = new ModelAndView("list");
		model.addObject("listEmployees", this.employeeService.listEmployee());
		return this.employeeService.listEmployee(); // this is a jsp page
	}

	
	
	  @RequestMapping(consumes ="application/json", produces =
	  "application/json", value = "/addjson",method = RequestMethod.POST)
	  
	  @ResponseBody public Employee addEmployees(@RequestBody Employee employee) {
			  System.out.println(employee.getName());
employeeService.addEmployee(employee);


return employee;
	  
	  }
			  @RequestMapping(consumes ="application/json", produces =
					  "application/json", value = "/deletejson/{id}",method = RequestMethod.DELETE)
			  
			  @ResponseBody 
			  public void removeEmployees(@PathVariable int id) {
					 // System.out.println(employee.getName());
		employeeService.removeEmployee(id);


		//return employeeService;
			  
			  }
	 
	 @RequestMapping(consumes ="application/json", produces =
			  "application/json", value = "/updatejson",method = RequestMethod.PUT)
			  
			  @ResponseBody public Employee updateEmployees(@RequestBody Employee emp) {
		
			 
			  System.out.println(emp.getName());
		employeeService.updateEmployee(emp);


		return emp;
			  
			  }
	
}
