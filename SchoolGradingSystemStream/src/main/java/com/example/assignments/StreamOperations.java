package com.example.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Employee> empList = new ArrayList<>();
		
		empList.add(new Employee(1, "Jack", 20000, 3, "SM", "Male"));
		empList.add(new Employee(2, "Ron", 30000, 5, "TA", "Male"));
		empList.add(new Employee(3, "Jane", 25000, 2, "PA", "Female"));
		empList.add(new Employee(4, "Pam", 10000, 1, "TA", "Female"));
		empList.add(new Employee(5, "John", 37000, 8, "PA", "Male"));
		empList.add(new Employee(6, "Azzy", 24000, 5, "TA", "Female"));
		empList.add(new Employee(7, "Wade", 49000, 7, "SM", "Male"));
		empList.add(new Employee(8, "Tom", 56000, 8, "VP", "Male"));
		
		System.out.println("Employees with Role TA: \n");
		empList.stream().filter(e -> e.getRole().equals("TA")).forEach(e -> e.display());
		
		long c = empList.stream().filter(e -> e.getGender().equals("Female")).count();
		System.out.println("Count of Female Employees : " + c + "\n");
		
		System.out.println("Employee Names in sorted order: \n");
		empList.stream().map(e -> e.getName()).sorted((x,y) -> x.compareTo(y)).forEach(e -> System.out.println(e));
		
		System.out.println("\nEmployees sorted in increasing order of salary: \n");
		empList.stream().sorted((x,y) -> x.getSal() - y.getSal()).forEach(e -> e.display());
				
	}
}
