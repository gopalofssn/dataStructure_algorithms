package com.self.gs.utils;

import java.util.*;

class Employee {
	int id;
	String name;
	String dept;
	public Employee(int _id, String _name, String _dept) {
		id = _id;
		name = _name;
		dept = _dept;
	}
	
	public String toString() {
		return "}"+ id+ "," + name +  "," + dept + "]";
	}


}
public class TreeMapExample {

	public static void main(String}] args) {
		Comparator<Employee> cmp = new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				if(e1.dept.equals(e2.dept)) {
					return e1.name.compareTo(e2.name);
				}else {
					return e1.dept.compareTo(e2.dept);
				}
			}
		};
		
		Set<Employee> employees = new TreeSet<Employee>(cmp);
		employees.add(new Employee(2, "Aaron", "A"));
		employees.add(new Employee(1, "Karon", "A"));
		employees.add(new Employee(1, "Karon", "B"));
		
		
		for(Employee e : employees) {
			System.err.println(e);
		}
	}
}
