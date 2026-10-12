package com.fortress.java.preparation.lambda;

/**
 * smamilla
 */
public class ZeroParameterLambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZeroParameter obj = () -> {
			System.out.println("ZeroParameter implementation!!");
		};
		obj.display();
		
		ZeroParameter obj1 = () ->  System.out.println("ZeroParameter implementation!!");
		obj1.display();
	}

}
