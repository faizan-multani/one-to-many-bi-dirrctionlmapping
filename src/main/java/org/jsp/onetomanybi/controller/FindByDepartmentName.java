package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;

public class FindByDepartmentName {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the department name to display the details");
	String name=sc.next();
	String jpql="select d from Department d where d.name=?1";
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q=manager.createQuery(jpql);
	q.setParameter(1,name);
	List<Department> dept=q.getResultList();
	if(dept.size()>0) {
		for(Department depts:dept) {
			System.out.println("Department id :"+depts.getId());
			System.out.println("Department name :"+depts.getName());
			System.out.println("Department location :"+depts.getLocation());
			System.out.println("--------------------------------------");
		}
	}
	else {
		System.err.println("in-valid name entered");
	}
}
}
