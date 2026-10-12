package com.fortress.java.preparation.generics.boundType;

public class TestBound<T extends Number /*& Number*/> { //4.	We can’t extend more than one class simultanously. 
	public static void main(String[] args) {
		TestBound<Integer> t1=new TestBound<Integer>();
		TestBound<Integer> t2=new TestBound<Integer>();
//		Test<String> t2=new Test<String>();
		//Test3<Runnable> t3=new Test3<Runnable>(); extend it to Runnable 
		
		
	}
}
