package com.example.studentspring;
import java.util.*;

public class Class {
    String nazwaGrupy;
    public List<Student> grupa;
    int maksymalnaIloscStudentow;
    double ocena;
    public int id;

    public Class(int id, String nazwaGrupy, List<Student> grupa, int maksymalnaIloscStudentow, double ocena) {
        this.id = id;
        this.nazwaGrupy = nazwaGrupy;
        this.grupa = grupa;
        this.maksymalnaIloscStudentow = maksymalnaIloscStudentow;
        this.ocena = ocena;
    }

    public void addStudent(Student student) {
        grupa.add(student);
    }

    public void addPoints(Student student, double punkty) {
        student.iloscPunktow += punkty;
    }

    public void getStudent(Student student) {
        if(student.iloscPunktow <= 0) {
            grupa.remove(student);
        }
    }

    public void changeCondition(Student student, StudentCondition condition) {

    }

    public void removePoints(Student student, double pontsRemove) {
        student.iloscPunktow -= pontsRemove;
    }

    public Student search(String nazwisko) {
        for (Student student : grupa) {
            if (student.compareTo(new Student(1,"",nazwisko,true,true,true,1,1))==0) {
                System.out.println("Znaleziono studenta o nazwisku: " + nazwisko + " w grupie: " + nazwaGrupy);
                System.out.println("Dane studenta: ");
                student.print();
                return student;
            }
        }
        System.out.println("Nie znaleziono studenta o nazwisku: " + nazwisko + " w grupie: " + nazwaGrupy);
        return null;
    }

    public List<Student> searchPartial(String string) {
        List<Student> students = new ArrayList<>();
        for (Student student : grupa) {
            if (student.imie.toLowerCase().contains(string.toLowerCase()) || student.nazwisko.toLowerCase().contains(string.toLowerCase())) {
                students.add(student);
            }
        }
        if(!students.isEmpty()) {
            System.out.println("Ilosc studentow w " + nazwaGrupy + " zawierajacych " + string + " w imieniu lub naziwsku: " + students.size());
            for(Student student: students) {
                student.print();
            }
            return students;
        }
        else {
            System.out.println("Nie ma studenta ktory w imieniu lub nazwisku zawiera " + string + " w grupie " + nazwaGrupy);
            return null;
        }


    }

    public int countByCondition(StudentCondition studentCondition) {
        int iloscOsob = 0;
        for(Student student:grupa) {
            if(student.chory == studentCondition.chory
                    || student.odrabiajacy == studentCondition.odrabiajacy || student.nieobecny == studentCondition.nieobecny) {
                iloscOsob++;
            }
        }
        if(iloscOsob > 0){
            System.out.println("Ilosc osob: " + iloscOsob
                    + " o Condition: " + studentCondition.odrabiajacy+ "," + studentCondition.chory + "," + studentCondition.nieobecny);
            return iloscOsob;
        }
        else {
            System.out.println("Nie ma takich studentow w grupie " + nazwaGrupy);
            return 0;
        }
    }

    public String summary() {
        String temp = new String();
        for(Student student : grupa) {
            //System.out.println("Grupa: " + nazwaGrupy);
            //student.print();student.
            temp+="Imie i nazwisko studenta: " + student.imie + temp + student.nazwisko
                    + "\nStan studenta:\nChory: " + student.chory + "\nOdrabiajacy: " + student.odrabiajacy
                    + "\nNieobecny: " + student.nieobecny + "\nRok urodzenia: " + student.rokUrodzenia + "\nIlosc punktow: " + student.iloscPunktow;

        }
        return temp;
    }

    public int getSize(){
        return grupa.size();
    }

    public void sortByName() {
        Collections.sort(grupa,new SortByName());
        for(Student student : grupa){
            System.out.println(student.imie);
        }
    }

    public void sortByPoints() {
        Collections.sort(grupa,Collections.reverseOrder(new SortByPoints()));
        for(Student student : grupa){
            System.out.println(student.iloscPunktow);
        }
    }

    public void max() {
        Student student = Collections.max(grupa, new SortByPoints());
        System.out.println(student.iloscPunktow);

    }

    public boolean isEmpty() {
        if(grupa.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void print() {
        System.out.println(grupa.size());
    }

    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }

    public void setGrupa(List<Student> grupa) {
        this.grupa = grupa;
    }

    public void setMaksymalnaIloscStudentow(int maksymalnaIloscStudentow) {
        this.maksymalnaIloscStudentow = maksymalnaIloscStudentow;
    }

    public List<Student> getGrupa() {
        return grupa;
    }

    public Student getStudent(int id) {
        for(Student student : grupa){
            if(student.id == id){
                System.out.println("chuj");
                return student;
            }
        }
        return null;
    }

}

