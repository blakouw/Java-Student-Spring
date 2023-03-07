package com.example.studentspring;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;

public class Main {
        public static void main(String[] args) throws SQLException {

                List<Student> list1 = new ArrayList<>();
                List<Student> list2 = new ArrayList<>();
                List<Student> list3 = new ArrayList<>();
                List<Student> list4 = new ArrayList<>();
                List<Student> list5 = new ArrayList<>();
                Map<String, Class> grupy = new TreeMap<>();

                Class grupa1 = new Class(1,"Grupa 1", list1, 8, 3);
                Class grupa2 = new Class(2,"Grupa 2", list2, 3, 3);
                Class grupa3 = new Class(3,"Grupa 3", list3, 13, 3);
                Class grupa4 = new Class(4,"Grupa 4", list4, 5, 3);

                grupa1.addStudent(new Student(1, "Kamil", "Starobrat", true, true,false,2001, 21));
                grupa1.addStudent(new Student(2, "Wojciech", "Szczesny", true, true,false,1990, 100));
                grupa2.addStudent(new Student(3, "Robert", "Kubica", true, true,false,1986, 89));
                grupa3.addStudent(new Student(4, "Robercik", "Lewandowski", true, true,false,1991, 9));
                grupa3.addStudent(new Student(5, "Grzegorz", "Bak", true, true,false,2000, 9));
                grupa3.addStudent(new Student(6, "Kacper", "Suder", true, true,false,2001, 9));



                grupa3.getStudent(6);

                //szkola.addClass(grupa1.nazwaGrupy,grupa1.grupa, grupa1.maksymalnaIloscStudentow);
                //szkola.addClass(grupa2.nazwaGrupy,grupa2.grupa, grupa2.maksymalnaIloscStudentow);
                //szkola.addClass(grupa3.nazwaGrupy,grupa3.grupa, grupa3.maksymalnaIloscStudentow);
                //szkola.addClass(grupa4.nazwaGrupy,grupa4.grupa, grupa4.maksymalnaIloscStudentow);
                //szkola.addClass(grupa5.nazwaGrupy,grupa5.grupa, grupa5.maksymalnaIloscStudentow);
                /*
                if(student8.compareTo(student9)==0){
                        System.out.println("Te same nazwiska");

                }
                else{
                        System.out.println("Rozne nazwiska");
                }
                */
                //grupa3.addPoints(student5, 45.5);
                //student1.setStudentCondition(false, false, false);
                //student1.print();
                //student8.setIStudentCondition(true, false, true);
                //student8.print();

                //grupa4.getStudent(student9);
                //grupa4.summary();

                //grupa1.sortByName();
                //grupa2.sortByName();
                //grupa3.sortByName();
                //grupa4.sortByName();

                //grupa1.sortByPoints();
                //grupa2.sortByPoints();
                //grupa3.sortByPoints();
                //grupa4.sortByPoints();

                //grupa1.max();
                //grupa2.max();
                //grupa3.max();
                //grupa4.max();

                //grupa.print();

                //szkola.removeClass("Grupa 1");
                //szkola.print();
                //grupa4.searchPartial("Bart");
                //grupa4.countByCondition(new StudentCondition(false,false,false));
                //grupa1.search("starobrat");
                //grupa3.search("Mazur");
                //grupa.searchPartial("Kowalski");
                //grupa.searchPartial("elo");
                //grupa.countByCondition(new StudentCondition(true, false, false));
                //szkola.print();
                //szkola.summary();
                //szkola.findEmpty();
                //grupa1.summary();


        }
}
