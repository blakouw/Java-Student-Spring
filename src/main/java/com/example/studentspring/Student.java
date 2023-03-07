package com.example.studentspring;
public class Student extends StudentCondition implements Comparable<Student> {
    public String imie, nazwisko;
    public int rokUrodzenia,id;
    public double iloscPunktow;

    public Student(int id, String imie, String nazwisko, boolean chory ,boolean odrabiajacy, boolean nieobecny, int rokUrodzenia, double iloscPunktow) {
        super(chory, odrabiajacy, nieobecny);
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
        this.iloscPunktow = iloscPunktow;
    }
    public void print() {
        String temp = " ";
        System.out.println("Imie i nazwisko studenta: " + imie + temp + nazwisko
                + "\nStan studenta:\nChory: " + chory + "\nOdrabiajacy: " + odrabiajacy
                + "\nNieobecny: " + nieobecny + "\nRok urodzenia: " + rokUrodzenia + "\nIlosc punktow: " + iloscPunktow);
    }


    @Override
    public int compareTo(Student student) {
        if(student.nazwisko.toLowerCase().equals(this.nazwisko.toLowerCase())) {
            return 0;
        }
        else {
            return 1;
        }
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }
    public void setIloscPunktow(double iloscPunktow) {
        this.iloscPunktow = iloscPunktow;
    }
    public void setStudentCondition(boolean chory, boolean odrabiajacy, boolean nieobecny) {
        this.chory = chory;
        this.odrabiajacy = odrabiajacy;
        this.nieobecny = nieobecny;
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", rokUrodzenia=" + rokUrodzenia +
                ", iloscPunktow=" + iloscPunktow +
                ", odrabiajacy=" + odrabiajacy +
                ", chory=" + chory +
                ", nieobecny=" + nieobecny +
                '}';
    }
}
