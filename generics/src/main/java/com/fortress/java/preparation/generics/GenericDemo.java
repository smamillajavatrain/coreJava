/*
 * package com.fortress.java.preparation.generics;
 * 
 * import java.util.ArrayList;
 * 
 *//**
	 * smamilla
	 */
/*
 * public class GenericDemo {
 * 
 *//**
	 * @param args
	 *//*
		 * public static void main(String[] args) {
		 * ArrayList<String> al1 = new ArrayList<String>();
		 * method1(al1);
		 * ArrayList<Integer> al2 = new ArrayList<Integer>();
		 * method1(al2);
		 * ArrayList<Double> al3 = new ArrayList<Double>();
		 * method1(al3);
		 * ArrayList<Character> al4 = new ArrayList<Character>();
		 * method1(al4);
		 * }
		 * 
		 * private static void method(ArrayList<String> al4) {
		 * al4.add(null);
		 * al4.add("A");
		 * // al4.add(20); //The method add(int, String) in the type ArrayList<String>
		 * is
		 * // not applicable for the arguments (int)
		 * }
		 * 
		 * 
		 * private static void method1(ArrayList<? extends X> al4) {
		 * X can be either class or interface
		 * 
		 * X can be class
		 * X can be Interface
		 * 
		 * X can be class then we can call this method by passing ArrayList of either X
		 * or it's subclass/child class
		 * X can be interface then we can call this method by passing ArrayList of
		 * either X or it's implemented class
		 * 
		 * 
		 * 
		 * // ? wild card character
		 * // we can call this method by passing ArrayList of any type
		 * // but within the method we can't add anything to the list except null
		 * // because we don't know the type exactly
		 * // this method are best suitable for read only operations
		 * al4.add(null);
		 * al4.add("Divya"); // The method add(capture#2-of ?) in the type
		 * ArrayList<capture#2-of ?>
		 * // is not applicable for the arguments (String)
		 * 
		 * 
		 * }
		 * 
		 * }
		 */