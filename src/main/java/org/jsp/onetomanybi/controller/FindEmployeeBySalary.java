package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Employee;

public class FindEmployeeBySalary {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter teh salary to get employee details");
	long salary=sc.nextLong();
	String qry="select e from Employee e where e.salary=?1";
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q=manager.createQuery(qry);
	q.setParameter(1,salary);
	List<Employee> emp=q.getResultList();
	
		 if(emp.size()>0) {
			for(Employee emps:emp) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("Employee id :"+emps.getId());
				System.out.println("Employee name :"+emps.getName());
				System.out.println("Employee designation :"+emps.getDesg());
				System.out.println("--------------------------------------");
			}
			if(salary>50000 ) {
				System.out.println(salary);
			}
			else {
				System.out.println("less salary");
			}
		}
		else {
		System.err.println("in-valid salary entered");
	}
	
}
}

