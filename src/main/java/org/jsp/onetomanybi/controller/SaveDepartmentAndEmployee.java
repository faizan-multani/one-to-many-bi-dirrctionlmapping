package org.jsp.onetomanybi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanybi.dto.Department;
import org.jsp.onetomanybi.dto.Employee;

public class SaveDepartmentAndEmployee {
	public static void main(String[] args) {
		Department d = new Department();
		d.setName("development");
		d.setLocation("bangalore");

		Employee e1 = new Employee();
		e1.setName("sasta-rolex");
		e1.setDesg("sasta-villain");
		e1.setSalary(5000);
		e1.setDept(d);

		Employee e2 = new Employee();
		e2.setName("vijay-verma");
		e2.setDesg("ghost");
		e2.setSalary(1000);
		e2.setDept(d);

		Employee e3 = new Employee();
		e3.setName("vikram");
		e3.setDesg("kamal-down");
		e3.setSalary(50000);
		e3.setDept(d);

		//d.setEmps(new ArrayList<Employee>(Arrays.asList(e1,e2,e3)));	
					// (or) one more way
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		d.setEmps(emps);

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(d);
		transaction.begin();
		transaction.commit();
	}
}
