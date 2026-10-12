package com.fortress.java.preparation.generics;

import java.util.ArrayList;

/*
 * @author smamilia
 */
public class Test4 {

    public static void m1(ArrayList list) {
        list.add(10);       // Autoboxed to Integer
        list.add(10.5);     // Autoboxed to Double
        list.add(true);     // Autoboxed to Boolean
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Sri");
        list.add("Sai");
        m1(list);
        
        System.out.println(list);
    }
}