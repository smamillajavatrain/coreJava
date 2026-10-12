package com.fortress.java.preparation.generics;

public class Account<T> { // generic unbounded class
    T object;

    public Account() {
        super();
    }

    public Account(T object) {
        this.object = object;
    }

    public void show() {
        if (object != null) {
            System.out.println("The Type of Object: " + object.getClass().getName());
        } else {
            System.out.println("Object is null.");
        }
    }

    public T getObject() {
        return object;
    }

    public static void main(String[] args) {
        Account<Gold> a = new Account<>();
        Account<Silver> a1 = new Account<>();
        Account<String> a2 = new Account<>("sai");
        a2.show();
        System.out.println(a2.getObject());

        Account<Integer> a3 = new Account<>(12);
        a3.show();
        System.out.println(a3.getObject());

        Account<Double> a4 = new Account<>();
        a4.show();
        System.out.println(a4.getObject());
    }
}

// Dummy classes to support the code
class Gold {}
class Silver {}
