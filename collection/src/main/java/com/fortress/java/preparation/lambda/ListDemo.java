package com.fortress.java.preparation.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fortress.java.preparation.collection.util.CollectionUtil;

/**
 * smamilla
 */
public class ListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> strList = CollectionUtil.populateGenericArrayList();
		System.out.println(strList);
		
		strList.forEach(e->System.out.println(e));
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,12,13,14);
		
		for(Integer e:intList) {
			if(e%2==0) {
				System.out.println(e);
			}
		}
		
		intList.forEach(e->{
			if(e%2==0) {
				System.out.println(e);
			}
		});
	}
}