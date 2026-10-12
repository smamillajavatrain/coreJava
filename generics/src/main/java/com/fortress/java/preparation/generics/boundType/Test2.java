package com.fortress.java.preparation.generics.boundType;
import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        m1(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        m1(list2);

        ArrayList<Double> list3 = new ArrayList<>();
        m1(list3);

        ArrayList<Character> list4 = new ArrayList<>();
        m1(list4);
    }

    // Single method to handle all types using wildcard
    private static void m1(ArrayList<?> list) {
        // Handle generic ArrayList here
    }
}