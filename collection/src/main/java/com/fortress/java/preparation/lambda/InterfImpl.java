package com.fortress.java.preparation.lambda;

/**
 * smamilla
 */
public class InterfImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interf obj = new Interf() {
			@Override
			public void display() {
				System.out.println("Annonumys class display method implementation!!");
			}
			
		};
		obj.display();
	}
}