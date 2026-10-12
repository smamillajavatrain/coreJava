package com.fortress.java.preparation.collection;

import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(124);
		ts.add(100);
		ts.add(107);
		ts.add(141);
		ts.add(101);
		ts.add(103);
		ts.add(104);
		ts.add(110);
		ts.add(115);
		ts.add(120);
		System.out.println(ts);
		System.out.println(ts.first()); // 100
		System.out.println(ts.last()); // 141
		System.out.println(ts.headSet(107));
		System.out.println(ts.tailSet(107));
		System.out.println(ts.subSet(107,141));

	}
}
