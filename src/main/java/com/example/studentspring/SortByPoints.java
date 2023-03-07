package com.example.studentspring;

import com.example.studentspring.Student;

import java.util.Comparator;

public class SortByPoints implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.iloscPunktow<o2.iloscPunktow)
            return -1;
        else if(o2.iloscPunktow<o1.iloscPunktow)
            return 1;
        return 0;
    }
}
