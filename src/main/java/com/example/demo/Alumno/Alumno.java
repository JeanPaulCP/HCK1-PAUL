package com.example.demo.Alumno;
import jakarta.persistence.*;

import com.example.demo.Grade.Grade;

import java.util.List; // Importamos la clase List

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String lastName;

    private String code;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Grade> grades;

    // Constructores
    public Alumno() {
    } // Constructor vacío

    public Alumno(Long id, String lastName, String code) {
        this.id = id;
        this.lastName = lastName;
        this.code = code;
    }

    // Getters
    public Long getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getCode() {
        return this.code;
    }

    public List<Grade> getGrades() {
        return this.grades;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

}
