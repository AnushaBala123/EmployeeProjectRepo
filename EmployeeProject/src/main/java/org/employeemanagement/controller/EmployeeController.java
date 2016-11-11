package org.employeemanagement.controller;

import org.employeemanagement.pojo.Employee;
import org.employeemanagement.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeService;



	public void setEmployeeService(EmployeeServiceInterface ps) {
		this.employeeService = ps;
	}

	@RequestMapping(value = "/listemploy", method = RequestMethod.GET)
	public ModelAndView listEmployee() {
		// model.addAttribute("employee", new Employee());
		//ModelAndView model = new ModelAndView("index");
		ModelAndView model = new ModelAndView("list");
		model.addObject("listEmployees", this.employeeService.listEmployee());//comment this 4 angs
		return model; // this is a jsp page
	}

	

	@RequestMapping(value = "addemployee", method = RequestMethod.POST)
	public ModelAndView addEmploy(@ModelAttribute Employee employee) {
		employeeService.addEmployee(employee);
		System.out.println(employee.getName());
		ModelAndView m = new ModelAndView(new RedirectView("listemploy"));
		m.addObject("listEmployees", this.employeeService.listEmployee());
		return m;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addrecord() {

		ModelAndView model = new ModelAndView("add");
		model.addObject("employee", new Employee());
		return model; // this is a jsp page
	}

	
	@RequestMapping(value = "/getupdateform/{id}", method = RequestMethod.GET)
	public ModelAndView getupdaterecord(@PathVariable("id") int id) {
		Employee employee = employeeService.getEmployee2(id);
		System.out.println(employee.getName());
		ModelAndView model = new ModelAndView("update");
		model.addObject("employee", employee);
		return model; 
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updaterecord(@ModelAttribute Employee employee) {
		employeeService.updateEmployee(employee);
		ModelAndView m = new ModelAndView(new RedirectView("listemploy"));
		m.addObject("listEmployees", this.employeeService.listEmployee());
		return m; 
	}
	@RequestMapping("/remove/{id}")
	public ModelAndView removeEmployee(@PathVariable("id") int id) {
		this.employeeService.removeEmployee(id);
		ModelAndView m = new ModelAndView(new RedirectView("/EmployeeProject/listemploy"));
		m.addObject("listEmployees", this.employeeService.listEmployee());
		return m;
	}




	
}
