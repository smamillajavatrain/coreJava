package com.fortress.java.preparation.lambda;

/**
 * smamilla
 */
public class LambdaExample1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// anonymous class as well as implemented anonymous function
		/*
		MathOperation addition1 = new MathOperation() {

			@Override
			public int operate(int a, int b) {
				return a+b;
			}
			
		};
		System.out.println(addition1.operate(40,50)); */
		
		/*
		 * Java8: Lambda Expressions concepts 
		        to implement functional programming in java introduced a concept called Lambda
		        
		   Objective of Lambda Expressions?
		   
		   The main objective of Lambda Expressions is to bring the benifits of functional programming into java
		   
		   what is Lambda Expressions?
		   
		   Lambda expression is an anonymous(nameless) function

				Step 1: It doesn't have access modifier/specifier
				Step 2: It doesn't have return type
				Step 3: It doesn't have method name
				Step 4: It doesn't have method parameter data type
				Step 5: insert the lambda expression ->
				Step 6: remove the return type
		   	
		   	public void add(int i,int j){
			  System.out.println(i+j);
			}
			
			Step 1: It doesn't have access modifier/specifier

					void add(int i,int j){
					  System.out.println(i+j);
					}
				Step 2: It doesn't have return type
					add(int i,int j){
					  System.out.println(i+j);
					}
				Step 3:It doesn't have method name
				      (int i,int j){
					  System.out.println(i+j);
					}
				
				Step 4: It doesn't have method parameter data type
				      (i,j){
					  System.out.println(i+j);
					}
				Step 5: insert the lambda expression ->
				
				(i,j)-> {
				  System.out.println(i+j);
				}
			
			  Step6: (i,j) -> System.out.println(i+j);
		   
		why use Lambda expressions?

				to provide the implementation of functional interface
				Less coding
				Enable functionality to be treated as a method argument or code as data
				A function can be created without belonging directly to a named class
				A lambda expression can be passes around like an object and executed on demand.
		*/

		// A lambda expression can be passes around like an object and executed on demand.
		MathOperation addition = (a,b) -> a + b;  // anonymous function
		MathOperation substraction = (a,b) -> a - b;
		MathOperation multiplication = (a,b) -> a * b;
		
		System.out.println("Addition of (10+20) = "+ addition.operate(10,20));
		System.out.println("Substraction of (30-20) = "+ substraction.operate(30,20));
		System.out.println("Multiplication of (30*20) = "+ multiplication.operate(30,20));
	}

}
