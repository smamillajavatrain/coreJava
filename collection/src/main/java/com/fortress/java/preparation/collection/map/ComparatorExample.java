package com.fortress.java.preparation.collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * smamilla
 */
public class ComparatorExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(103, "Divya", 70000));
        employees.add(new Employee(101, "Sree", 90000));
        employees.add(new Employee(102, "Vihas", 60000));

        System.out.println("Before sorting:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Before Java 8: anonymous inner class
        Comparator<Employee> salaryDescending =
                new Comparator<Employee>() {

                    @Override
                    public int compare(Employee e1, Employee e2) {
                        return Double.compare(
                                e2.getSalary(), e1.getSalary());
                    }
                };

        Collections.sort(employees, salaryDescending);

        System.out.println("\nAfter sorting by salary descending:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

}
