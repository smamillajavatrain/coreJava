package com.fortress.java.preparation.generics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
public final class GenericsUtil {
    private GenericsUtil() {}
    public static <T> T first(List<T> values) {
        if (values == null || values.isEmpty()) throw new IllegalArgumentException("values must not be empty");
        return values.get(0);
    }
    public static <T extends Number> double sum(Collection<T> values) {
        double total=0; for (T value: values) total += value.doubleValue(); return total;
    }
    public static double sumNumbers(List<? extends Number> values) {
        double total=0; for (Number n: values) total += n.doubleValue(); return total;
    }
    public static void addIntegers(List<? super Integer> target) {
        target.add(10); target.add(20); target.add(30);
    }
    public static void printAll(List<?> values) {
        for (Object value: values) System.out.println("  "+value);
    }
    public static <T> void copy(List<? extends T> source, List<? super T> destination) {
        for (T item: source) destination.add(item);
    }
    @SafeVarargs public static <T> List<T> listOf(T... values) {
        List<T> result=new ArrayList<>(); for(T value:values) result.add(value); return result;
    }
    public static <T> boolean contains(Collection<? extends T> values, T target) {
        for(T value:values) if(Objects.equals(value,target)) return true; return false;
    }
}
