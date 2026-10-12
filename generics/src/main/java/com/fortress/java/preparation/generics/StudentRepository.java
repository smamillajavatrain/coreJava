package com.fortress.java.preparation.generics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
/** Small in-memory repository example. */
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();
    public void save(Student student) { students.add(student); }
    public Optional<Student> findById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }
    public List<Student> findAllSorted() {
        List<Student> copy = new ArrayList<>(students);
        Collections.sort(copy);
        return copy;
    }
}
