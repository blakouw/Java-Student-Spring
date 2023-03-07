package com.example.studentspring.web;

import com.example.studentspring.Class;
import com.example.studentspring.ClassContainer;
import com.example.studentspring.Data;
import com.example.studentspring.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
public class SpringController {
    @Autowired
    private Data data;

    @GetMapping("/api/student/csv")
    public void doCSV() throws IOException {
        this.data.givenDataArray_whenConvertToCSV_thenOutputCreated();
    }
    @PostMapping("/api/student/{id}")
    public void dodajStudenta(@RequestBody Student student, @PathVariable("id") int id) {
        this.data.addStudent(student, id);
    }
    @DeleteMapping("/api/course/remove/student/{idg}/{ids}")
    public void usunStudenta(@PathVariable("idg") int idg, @PathVariable("ids") int ids){
        this.data.usunStudenta(idg,ids);
    }
    @DeleteMapping("/api/course/remove/{id}")
    public void usunGrupe(@PathVariable("id") int id) {
        this.data.usunGrupe(id);
    }

    @GetMapping("/api/course/student/{id}/grade")
    public double getOcena(@PathVariable("id") int id) {
        return this.data.ocenaStudenta(id);
    }
    @GetMapping("/api/course")//5
    public Map<Integer, Class> wyswietlSzkole() {
        return this.data.wyswietlSzkola();
    }

    @PostMapping("api/course/add")
    public List<Student> dodajGrupe(@RequestParam String id,@RequestParam String nazwa,@RequestParam String wielkosc,@RequestParam String ocena) {
        int idd = Integer.parseInt(id);
        int size = Integer.parseInt(wielkosc);
        double oc = Double.parseDouble(ocena);
        Class clas = this.data.addGrupa(idd,nazwa,size,oc);
        return clas.grupa;
    }


    @GetMapping("/api/course/{id}/students")
    public List<Student> wyswietlGrupe(@PathVariable("id") int id){
        return this.data.wyswietlGrupe(id);
    }

    @GetMapping("/api/course/fill")//9
    public String wyswietlZapelnienie() {
        return this.data.fillGroups();
    }
    @GetMapping("/api/course/student/{ids}")
    public Student wyswStudenta(@PathVariable("ids") int ids ){
        return this.data.wyswietlStudenta(ids);
    }

}
