package org.employeemanagement.dao;

import java.util.List;

import org.employeemanagement.pojo.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeDAO implements EmployeeDAOInterface {

	@Autowired
	SessionFactory sessionFactory;

	// adding an employee
	public Employee addEmployee(Employee employee) {

		Session session = sessionFactory.openSession();
		session.persist(employee);
		session.flush();
		return employee;
	}

	public Employee updateEmployee(Employee emp) {
		
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(emp);
		//System.out.println("employee updated successfully, employee Details=" + employee);
		session.flush();
		return emp;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee() {                    

		Session session = sessionFactory.openSession();
		List<Employee> employeelist = session.createQuery("from Employee").list();
		for (Employee e : employeelist) {
			System.out.println("employeelist" + e);
			System.out.println(e.getName());
		}
		return employeelist;
	}
	
	

	public Employee getEmployee2(int id) {
		
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class, id);
		session.flush();
		return employee;
	}

	public void removeEmployee(int id) {

		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class, id);
		session.delete(employee);
		System.out.println("employee updated successfully, employee Details=" + employee);
		session.flush();

	}
}

/*
 * Employee employee = (Employee)
 * session.getCurrentSession().load(Employee.class, new Integer(id)); if(null !=
 * employee){ ((EmployeeDAO) session).delete(employee); } System.out.println(
 * "employee deleted successfully, employee details="+employee);
 */

/*
 * private void deleteEmployee(Employee employee) { Session
 * session=sessionFactory.openSession(); session.createQuery(
 * "DELETE FROM Employee WHERE empid = "+employee.getEmpId()).executeUpdate();
 * 
 * // TODO Auto-generated method stub
 * 
 * }
 */