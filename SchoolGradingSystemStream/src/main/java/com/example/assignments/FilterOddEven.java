package com.example.assignments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterOddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <Integer> list = Arrays.asList(1,2,4,6,2,3,5,7,8,10,15,66,23);
		
		Stream <Integer> oddStream = list.stream().filter(x -> x%2!=0);
		Stream <Integer> evenStream = list.stream().filter(x -> x%2==0);
		
		System.out.println("Odd Numbers : \n");
		oddStream.forEach(t -> System.out.println(t));


		System.out.println("\nEven Numbers : \n");
		evenStream.forEach(t -> System.out.println(t));
	}

}
