package com.fortress.java.preparation.collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * smamilla
 */
public class MultipleComparatorExample {

	public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(103, "Divya", 70000));
        employees.add(new Employee(101, "Sree", 90000));
        employees.add(new Employee(102, "Vihas", 60000));

        // Sort by employee name ascending
        Comparator<Employee> nameAscending =
                new Comparator<Employee>() {
                    @Override
                    public int compare(Employee e1, Employee e2) {
                        return e1.getName().compareTo(e2.getName());
                    }
                };

        System.out.println("Before sorting: " + employees);

        Collections.sort(employees, nameAscending);
        System.out.println("\nSorted by name ascending: " + employees);

        // Sort by salary ascending
        Comparator<Employee> salaryAscending =
                new Comparator<Employee>() {
                    @Override
                    public int compare(Employee e1, Employee e2) {
                        return Double.compare(
                                e1.getSalary(), e2.getSalary());
                    }
                };

        Collections.sort(employees, salaryAscending);
        System.out.println("\nSorted by salary ascending: " + employees);

        // Sort by salary descending
        Comparator<Employee> salaryDescending =
                new Comparator<Employee>() {
                    @Override
                    public int compare(Employee e1, Employee e2) {
                        return Double.compare(
                                e2.getSalary(), e1.getSalary());
                    }
                };

        Collections.sort(employees, salaryDescending);
        System.out.println("\nSorted by salary descending: " + employees);
    }
}
