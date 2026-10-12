package com.fortress.java.preparation.generics;
public class Student implements Comparable<Student> {
    private final int id; private final String name; private final double score;
    public Student(int id, String name, double score) { this.id=id; this.name=name; this.score=score; }
    public int getId() { return id; } public String getName() { return name; } public double getScore() { return score; }
    @Override public int compareTo(Student other) {
        int byScore = Double.compare(score, other.score);
        return byScore != 0 ? byScore : name.compareTo(other.name);
    }
    @Override public String toString() { return "Student{id="+id+", name='"+name+"', score="+score+"}"; }
}
