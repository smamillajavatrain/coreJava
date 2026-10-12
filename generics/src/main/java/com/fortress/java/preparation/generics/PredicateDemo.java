package com.fortress.java.preparation.generics;

import java.util.function.Predicate;

/**
 * smamilla
 */
public class PredicateDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Predicate<Integer> pr = i -> i % 2 == 0;
		for (int n = 0; n < 100; n++) {
			boolean b = pr.test(n);
			System.out.println("the cond is "+b+" and value is "+n);
		}
	}
	
	boolean test(Integer i) {
		return i % 2 == 0;
	}
}