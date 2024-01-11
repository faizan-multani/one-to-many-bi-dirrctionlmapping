package org.jsp.onetomanybi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Employee;

public class FindByEmployeeId {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the employee id to diplay details");
	int id=sc.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Employee e=manager.find(Employee.class,id);
	if(e!=null) {
		System.out.println("Employee id :"+e.getId());
		System.out.println("Employee name :"+e.getName());
		System.out.println("Employee designation :"+e.getDesg());
		System.out.println("Employee salary :"+e.getSalary());
		System.out.println("--------------------------------------");
	}
	else {
		System.err.println("in-valid id entered");
	}
}
}
