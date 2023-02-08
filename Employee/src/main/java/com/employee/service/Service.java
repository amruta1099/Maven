package com.employee.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.employee.entity.Address;
import com.employee.entity.Employee;
import com.employee.exception.GlobalException;



public class Service {

	private static List<Employee> employee=new ArrayList<Employee>();
	Scanner sc=new Scanner(System.in);


	//method to add employee details in array list
	public void addEmployee(long empId,String name,double salary,
			String city,String country)
	{
		Address address =new Address(city, country);
		employee.add(new Employee(empId, name, salary, address));
	}
	//for testing using builder annotation
	public void addEmp(Employee emp)
	{
		employee.add(emp);		//adding the employee details
	}

	//method to display all employee details
	public void displayAllEmployee()
	{
		//printing all the details 
		for(Employee emp:employee)
		{
			System.out.println("Employee Id"+emp.getEmpId());
			System.out.println(" Employee name"+emp.getName());
			System.out.println("Employee salary"+emp.getSalary());
			System.out.println("Employee Address"+emp.getAddress().getCity()
					+","+emp.getAddress().getCountry());	
		}
	}

	public Employee displayEmpById(int id) throws GlobalException
	{
		//displaying the details of employee by id
		for( int i=0;i<employee.size();i++)
		{
			if(employee.get(i).getEmpId()==id)
{
	return employee.get(i);
}
			else
			{
				throw new GlobalException("Employee Id not found!!");
			}
		}
		return null;
	}

	//update employee
	public Employee UpdateEmp(int index,Employee emp)
	{
		//updating the details of employee
		return employee.set(index, emp);
	}

	public Employee findId(int id)
	{
		//finding the employee byId
		Employee emp=null;
		for(int i=0;i<employee.size();i++)
		{
			if(employee.get(i).getEmpId()==id)
			{
				emp=employee.get(i);
			}
		}
		return emp;
	}

	public int  lengthOfList()
	{
		//count the length of list
		return employee.size();
	}

	public void RemoveId(int id)
	{
		//removing the details by id
		for(int i=0;i<employee.size();i++)
		{
			if(employee.get(i).getEmpId()==id)
			{
				employee.remove(i);
			}
		}

	}
	public void RemoveAlllemployee()
	{
		//removing all the details
		employee.clear();
	}
	/*public void RemoveAlllemployee()
	{
		//removing all the details
		employee.clear();
		return "All employed removed";
	}*/
	public double calculateYearSalary(int id)
	{
		double yearSalary=0.0;
		for(int i=0;i<employee.size();i++)
		{
			if(employee.get(i).getEmpId()==id)
			{
				yearSalary=employee.get(i).getSalary()*12;
			}
		}
		return yearSalary;
	}
	public double calculateApparasal(int id)
	{
		double apparasal=0.0;

		for(int i=0;i<employee.size();i++)
		{
			if(employee.get(i).getEmpId()==id)
			{
				if(employee.get(i).getSalary()<10000)
				{
					apparasal=1000;	

				}
				else if((employee.get(i).getSalary()>10000) && (employee.get(i).getSalary()<20000))
				//else
				{
					apparasal=2000;	
				}
				else
				{
					apparasal=2500;
				}
			}
		}
		return apparasal;
	}
	}