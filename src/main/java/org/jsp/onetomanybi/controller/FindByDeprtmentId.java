package org.jsp.onetomanybi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetomanybi.dto.Department;

public class FindByDeprtmentId {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the Department id to display details");
	int id=sc.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Department d=manager.find(Department.class,id);
	if(d!=null) {
		System.out.println("Department id :"+d.getId());
		System.out.println("Department name :"+d.getName());
		System.out.println("Department location :"+d.getLocation());
		System.out.println("--------------------------------------");
	}
}
}
