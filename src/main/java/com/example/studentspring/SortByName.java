package com.example.studentspring;

import com.example.studentspring.Student;

import java.util.Comparator;

public class SortByName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.imie.compareTo(o2.imie);
    }
}
