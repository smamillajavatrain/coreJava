package com.fortress.java.preparation.collection.map;

/**
 * 
 * smamilla
 */
class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Natural ordering: Employee ID ascending
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id
                + ", name='" + name + '\''
                + ", salary=" + salary + '}';
    }
}