package com.example.studentspring;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassContainer {
    Map<Integer,Class> grupy;
    public double ocena;

    public ClassContainer(Map<Integer, Class> grupy) {

        this.grupy = grupy;
        this.ocena = ocena;
    }

    public void addClass(int id, String nazwaGrupy, List<Student> grupa, int pojemnosc, double ocena) {
        grupy.put(id,new Class(id,nazwaGrupy, grupa, pojemnosc, ocena ));
    }
    public void removeClass(int id) {
        grupy.remove(id);
    }
    public void print() {
        System.out.println(grupy);
    }
    public List<Class> findEmpty() {
        List<Class> pusteGrupy = new ArrayList<>();
        for(Class grupa : grupy.values()) {
            if(grupa.getSize()==0){
                pusteGrupy.add(grupa);
            }
        }
        for(Class grupa : pusteGrupy) {
            System.out.println("Grupa: " + grupa.nazwaGrupy + " jest pusta");
        }

        return pusteGrupy;
    }
    public String summary() {
        String zapelnienie = new String();
        for (Class grupa : grupy.values()) {
            zapelnienie += "Nazwa grupy: " + grupa.nazwaGrupy + " Procentowe zapelnienie: " + (grupa.getSize()/grupa.maksymalnaIloscStudentow) * 100.0 + "%\n";
        }
        return zapelnienie;
    }
    public List<String> printSzkola() {
        return null;
    }
}
