package com.fortress.java.preparation.generics;

import java.util.ArrayList;

/**
 * smamilla
 */
public class GeenricDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();  // generic way
		al.add("sree");
		al.add("divya");
		al.add("bhargav");
		String ele1 = al.get(0);
		System.out.println(ele1);
		
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<Employee> al2 = new ArrayList<Employee>();
		
		ArrayList rawAl = new ArrayList();  // non generic way
		String s = (String) rawAl.get(0);
	}

}

class Employee{
	
}