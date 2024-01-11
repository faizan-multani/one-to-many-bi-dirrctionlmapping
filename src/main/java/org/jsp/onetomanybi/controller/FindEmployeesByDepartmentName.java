package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Employee;

public class FindEmployeesByDepartmentName {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the department name to get employee details");
		String dept=sc.next();
		String qry="select d.emps from Department d where d.name=?1";
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q=manager.createQuery(qry);
		q.setParameter(1,dept);
		List<Employee> emp=q.getResultList();
		if(emp.size()>0) {
			for(Employee emps:emp) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("Employee id :"+emps.getId());
				System.out.println("Employee name :"+emps.getName());
				System.out.println("Employee designation :"+emps.getDesg());
				System.out.println("--------------------------------------");
			}
		}
		else {
			System.err.println("in-valid department name");
		}
	}
}
