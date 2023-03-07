package com.example.studentspring;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class Data {
    private static final String CSV_FILE_NAME = "students.csv";
    private static List<Student> list = new ArrayList<>();

    public static List<Student> list1 = new ArrayList<>();
    public static List<Student> list2 = new ArrayList<>();
    private static List<Student> list3 = new ArrayList<>();
    private static List<Student> list4 = new ArrayList<>();
    public static Map<Integer, Class> grupy = new TreeMap<>();
    public static double ocena;
    public static ClassContainer szkola = new ClassContainer(grupy);
    public static List<Class> szkolaL = new ArrayList<>();
    public static List<String> dat = new ArrayList<>();

    static{

        Class grupa1 = new Class(1,"Grupa 1", list1, 8, ocena);
        Class grupa2 = new Class(2,"Grupa 2", list2, 3, ocena);
        Class grupa3 = new Class(3,"Grupa 3", list3, 13, ocena);
        Class grupa4 = new Class(4,"Grupa 4", list4, 5, ocena);

        grupa1.addStudent(new Student(1, "Kamil", "Starobrat", true, true,false,2001, 21));
        grupa1.addStudent(new Student(2, "Wojciech", "Szczesny", true, true,false,1990, 100));
        grupa2.addStudent(new Student(3, "Robert", "Kubica", true, true,false,1986, 89));
        grupa3.addStudent(new Student(4, "Robercik", "Lewandowski", true, true,false,1991, 9));
        grupa3.addStudent(new Student(5, "Grzegorz", "Bak", true, true,false,2000, 9));
        grupa3.addStudent(new Student(6, "Kacper", "Suder", true, true,false,2001, 9));
        for(Student student: grupa1.grupa){
            list.add(student);
        }
        for(Student student: grupa2.grupa){
            list.add(student);
        }
        for(Student student: grupa3.grupa){
            list.add(student);
        }
        for(Student student: grupa4.grupa){
            list.add(student);
        }
        grupy.put(1,grupa1);
        grupy.put(2,grupa2);
        grupy.put(3,grupa3);
        grupy.put(4,grupa4);

    }
    //konwersja do csv
    public String convertToCSV(String data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }
    public void fill(){
        dat.add("id;Imie;Nazwisko;Chory;Odrabiajacy;Nieobecny;Urodzony;Punkty");
        for(Student s: list){
            dat.add(Integer.toString(s.id)+";"+s.imie+";"+s.nazwisko+";"+Boolean.toString(s.chory)+";"+
                    Boolean.toString(s.odrabiajacy)+";"+Boolean.toString(s.nieobecny)+";"+Integer.toString(s.rokUrodzenia)+";"+Double.toString(s.iloscPunktow));
        }
    }
    public void givenDataArray_whenConvertToCSV_thenOutputCreated() throws IOException {
        fill();
        File csvOutputFile = new File(CSV_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dat.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
        assertTrue(csvOutputFile.exists());

    }
    private void assertTrue(boolean exists) {
    }
    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
    //dodawanie studenta

    public String fillGroups(){
        String zapelnienie = new String();
        for (Class grupa : szkola.grupy.values()) {
            zapelnienie += "Nazwa grupy: " + grupa.nazwaGrupy + " Procentowe zapelnienie: " + (grupa.getSize()/grupa.maksymalnaIloscStudentow) * 100.0 + "%\n";
        }
        return zapelnienie;
    }

    public Map<Integer, Class> wyswietlSzkola() {
        return szkola.grupy;
    }
    //9
    public List<Student> wyswietlGrupe(int id) {
        Class grupa = null;
        grupa = szkola.grupy.get(id);
        List<Student> grupa1 = grupa.grupa;
        return grupa1;
    }
    public Student wyswietlStudenta(int id) {
        Student student = null;
        student = list.get(id-1);
        return student;
    }//DZIALA
    public double ocenaStudenta(int id) {
        Student student = null;
        student = list.get(id-1);
        //student = szkola.stream().filter(e -> e.getId() == id).findFirst().get();
        return student.iloscPunktow;

    }
    public void addStudent(Student student, int id) {
        list.add(student);
        Class grupa = null;
        grupa = szkola.grupy.get(id);
        grupa.addStudent(student);

    }

    public Class addGrupa(int id, String nazwaGrupy, int maksymalnaIloscStudentow, double ocena) {
        Class c = new Class(id,nazwaGrupy,new ArrayList<>(),maksymalnaIloscStudentow,ocena);
        szkola.addClass(c.id,c.nazwaGrupy,c.grupa,c.maksymalnaIloscStudentow,c.ocena);
        return c;
    }

    public void usunGrupe(int id) {
        for(Class c : szkola.grupy.values()){
            if(c.id == id){
                szkola.removeClass(id);
            }
        }
    }
    public void usunStudenta(int idg, int ids) {
        Student student = null;
        for(Class c : szkola.grupy.values()){
            if(c.id == idg){
                c = szkola.grupy.get(idg);
                student = c.getStudent(ids);
                c.grupa.remove(student);
                list.remove(student);


            }
        }

    }

}

