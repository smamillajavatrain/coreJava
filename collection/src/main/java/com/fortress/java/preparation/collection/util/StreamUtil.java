/**
 * 
 */
package com.fortress.java.preparation.collection.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author smamilla
 *
 */
public class StreamUtil {

	public static List<Employee> getEmployeeList() {
		List<Employee>  list = new ArrayList<>();
		list.add(new Employee(1, "sree", 40, 100.23d));
		list.add(new Employee(1, "Vihas", 10, 110.23d));
		return list;
	}
	
	public static List<String> strList = Arrays.asList(
			new String("Prasad"),
			new String("Sree"),
			new String("Vihas"),
			new String("Kalyani"),
			new String(""),
			new String(""),
			new String("SNL"),
			new String("Cha"),
			new String("Bha"),
			new String("Hyma"));
	public static List<String> countryList = Arrays.asList("India", "USA", "Japan", "France", "Germany", 
									"Italy", "U.K.","Canada"); 
	public static List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
	
	public static List<Integer> intList = Arrays.asList(2,3,5,4,2,3,2,4,6,4);
	
	public static List<Integer> numbers1 = Arrays.asList(1,2,13,4,15,6,17,8,19);
	
	public static Map<String, Integer> getMap(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 100);
		map.put("two", 80);
		map.put("three", 120);
		map.put("four", 80);
		return map;
	}
	public static List<String> words = Arrays.asList("GFG", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");
	
}