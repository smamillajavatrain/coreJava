package com.fortress.java.preparation.generics;

import java.io.Serializable;
import java.util.HashMap;

//public class Test<T> {  // unbounded type

public class Test<T extends Number & Runnable & Serializable>{ // bounded type
	/* restricts the type argument to a particular range using the extends keyword 
	 * extends only inherited classes
	 * X either inherited classes or implemented class
	    
	    class Test<T extends X>
	    
	    X can be class
	    X can be Interface
	    
	    X can be class then type parameter must be that class or subclass of X
	    X can be interface then type parameter must be interface or it's implemented class 
	   
	    Multiple bound parameter  are possible
	    first we need write class then interface
	    
	    when combining a class and interface the class bound must appear first the followed by interface bounds
	    Java does not support extending multiple classes
	    
	    class Test<T> unbound type
	    class Test<T extends Number> bounded type      extending class
	    class Test<T extends Runnable> bounded type    implementing interface
	    class Test<T extends Number & Runnable> bounded type   
	    
	the keyword extends is used both classes and interfaces in generic bounds
	implements and super are not used in the declaration of tyoe parameter bound
	
	one class first extends then implementation because we to take class first followed by interface next
	we can't extend more than one class simultanously
	
	HashMap<K,V>{
	
	}
	
	class Test<Integer,String>
	class HashMap<Integer,String>
	
	
	*/
	public static void main(String[] args) {
		/*
		 * Test<Integer> obj1 = new Test<Integer>();
		 * Test<String> obj2 = new Test<String>();
		 * Test<Number> obj3 = new Test<Number>();
		 * Test<Double> obj4 = new Test<Double>();
		 */
//		Test<Integer> obj1 = new Test<Integer>();
//		Bound mismatch: The type Integer is not a valid substitute 
//		for the bounded parameter <T extends Runnable> of the type Test<T>
//		Test<Runnable> obj2 = new Test<Runnable>();
//		Test<Thread> obj3 = new Test<Thread>();
		Test<Sample> obj4 = new Test<Sample>();
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "sai");
	}

}
