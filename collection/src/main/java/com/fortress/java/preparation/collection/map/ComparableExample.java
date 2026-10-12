package com.fortress.java.preparation.collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * smamilla
 */
public class ComparableExample {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(103, "Divya", 70000));
        employees.add(new Employee(101, "Sree", 90000));
        employees.add(new Employee(102, "Vihas", 60000));

        System.out.println("Before sorting:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Uses Employee.compareTo()
        Collections.sort(employees);

        System.out.println("\nAfter sorting by ID ascending:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

/*
	Comparable vs Comparator in Java
	
	Before Java 8, both Comparable and Comparator were used to sort objects. The main difference is where the sorting logic is defined and how many sorting strategies you can support.
	- Comparable → defines the natural/default sorting order inside the class.
	- Comparator → defines external/custom sorting logic outside the class.

	1. Key differences
		Feature					Comparable							Comparator
		Package					java.lang							java.util
		Method					compareTo(T obj)					compare(T o1, T o2)
		Sorting logic			Inside the model class				Outside the model class
		Purpose					Natural/default ordering			Custom ordering
		Number of strategies	Usually one natural order			Multiple custom orders
		Modifies model class?	Yes, it must implement Comparable	No
		Sorting API				Collections.sort(list)				Collections.sort(list, comparator)
		Before Java 8			Supported							Supported
		Typical example			Employee ID ascending				Salary descending, name ascending
		
		How compareTo() works:
			return Integer.compare(this.id, other.id);

		- Negative value: current employee comes before the other employee.
		- Zero: both are equal according to this sorting comparison.
		- Positive value: current employee comes after the other employee.
		Avoid this.id - other.id because integer subtraction can overflow.
	
		Q1. Can we sort objects without implementing Comparable?
			Yes. Provide a Comparator to Collections.sort(list, comparator).
		Q2. Can a class implement both interfaces?
			Yes. Comparable provides natural ordering; one or more Comparator implementations can provide alternate ordering.
		Q3. What happens if compareTo() returns zero?
			The objects are equal for that comparison. It does not necessarily mean their equals() method returns true.
		Q4. Can we use Comparator with TreeSet or TreeMap?
			Yes. You can supply a comparator when constructing them:
		TreeSet<Employee> employees =
		        new TreeSet<>(salaryDescending);
		
		
		Q5. What is the key difference in one sentence?
			Comparable defines the object's natural ordering inside the class; Comparator defines an alternative ordering externally.

*/