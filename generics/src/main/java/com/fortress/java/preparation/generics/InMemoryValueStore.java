package com.fortress.java.preparation.generics;
public class InMemoryValueStore<T> implements ValueStore<T> {
    private T value;
    @Override public void save(T value) { this.value = value; }
    @Override public T find() { return value; }
}
