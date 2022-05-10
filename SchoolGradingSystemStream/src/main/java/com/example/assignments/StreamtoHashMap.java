package com.example.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StreamtoHashMap {

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
		
		System.out.println("Converting Stream into HashMap \n");
		HashMap<Integer,String> hm = empList.stream().collect(Collectors.toMap(e -> e.getId(), e-> e.getName(),(x,y) -> x + "," +y,HashMap::new));
		hm.forEach((x,y) -> System.out.println( x + ":" + y));

	}

}
