package com.employee.servicetest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.employee.entity.Address;
import com.employee.entity.Employee;
import com.employee.exception.GlobalException;
import com.employee.service.Service;

@TestMethodOrder(value =OrderAnnotation.class)
public class EmployeeServiceTest {
	static Service employeeService;
	static List<Employee> emplist;
	
	@BeforeEach
	void setUp() throws Exception{
		employeeService = new Service();
	}
	
	@AfterEach
	void tearDown() throws Exception{
		employeeService = null;
		System.out.println("Object is garbage collected!!");
	}
	
	@Test
	@Order(1)
	@DisplayName("Testing add employee method")
	void testAddEmployee()
	{
		//way 1
//		employeeService.addEmployee(123, "Gauri", 25000, "Bihar", "India");
//		employeeService.addEmployee(199, "Amruta", 30000, "Maharashtra", "India");
//		assertEquals(2, employeeService.lengthOfList());
		
		//way 2
		Address add = Address.builder().city("pune").country("India").build();
		Employee emp = Employee.builder().empId(123).name("Vaibhav").salary(25000).
				address(add).build();
		employeeService.addEmp(emp);
		int length = employeeService.lengthOfList();
		//employeeService.displayAllEmployee();
		assertThat(length>0).isTrue();
	}
	
	@Test
	@Order(3)
	@DisplayName("Testing display employee by Id")
	void testDisplayByEmpId() throws GlobalException{
		Address add = Address.builder().city("pune").country("India").build();
		Employee emp = Employee.builder().empId(123).name("Vaibhav").salary(25000).
				address(add).build();
		employeeService.addEmp(emp);
		Employee e =employeeService.displayEmpById(123);
		//assertEquals("Vaibhav", e.getName());
		assertThat(e.getSalary()).isEqualByComparingTo(25000.00);
	}
	
	@Test
	@Order(2)
	@DisplayName("Testing update employee")
	void testUpdateEmployee()
	{
		Address add = Address.builder().city("pune").country("India").build();
		Employee emp = Employee.builder().empId(123).name("Vaibhav").salary(25000).
				address(add).build();
		employeeService.addEmp(emp);
		Employee e =employeeService.findId(123);
		e.setName("Amruta");
		
		employeeService.UpdateEmp(0, e);
		//employeeService.displayAllEmployee();
		//assertEquals("Amruta", e.getName());
		assertThat(e.getName()).isEqualTo("Amruta");
		
	}
	
	@Test
	@Order(4)
	@DisplayName("Testing Deleting all employees")
	void testDeleteAllEmployee()
	{
		employeeService.RemoveAlllemployee();
		assertEquals(0,employeeService.lengthOfList());
	}
	
	@Test
	void testCalculateYearlySalary()
	{
		Address add = Address.builder().city("Pune").country("India").build();
		Employee emp = Employee.builder().empId(145).name("amruta").salary(30000).
				address(add).build();
		employeeService.addEmp(emp);
		double sal =employeeService.calculateYearSalary(145);
		assertEquals(360000, sal);
	}
}
