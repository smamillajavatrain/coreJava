package com.fortress.java.preparation.generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * smamilla
 */
public class StreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<String> l1 = Arrays.asList("Sree","Divya","Bhargav","Vihas","kalyani");
		System.out.println(l);
		/*
		 * Stream<Integer> s = l.stream();
		 * Stream<Integer> s1 = s.filter(i-> i % 2 == 0); // Predicate FI boolean test
		 * s1.forEach(System.out::println);
		 */
		List<Integer> l2 = l.stream().filter(i-> i % 2 == 0).collect(Collectors.toList());
		System.out.println(l2);
		
		for(String str:l1) {
			System.out.println("originalstring as "+str+" and upper case for the string is "+str.toUpperCase());
			System.out.println("originalstring as "+str+" and length of the string is "+str.length());
			System.out.println("originalstring as "+str+" and lower case for the string is "+str.toLowerCase());
		}
		List<String> l3 = l1.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(l3);
		
		List<String> l5 = l1.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(l5);
		
		List<Integer> l4 = l.stream().map(i -> i * i).collect(Collectors.toList());
		System.out.println(l4);
		// Function functional interface  apply
	}

}
