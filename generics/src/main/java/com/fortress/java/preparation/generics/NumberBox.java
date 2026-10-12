package com.fortress.java.preparation.generics;
/** T can be Number or a subclass of Number. */
public class NumberBox<T extends Number> {
    private final T number;
    public NumberBox(T number) { this.number = number; }
    public T getNumber() { return number; }
    public double doubleValue() { return number.doubleValue(); }
}
