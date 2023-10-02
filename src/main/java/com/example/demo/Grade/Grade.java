package com.example.demo.Grade;
import jakarta.persistence.*;

import com.example.demo.Alumno.Alumno;

@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Alumno alumno;

    private Long score;

    // Constructores
    public Grade() {} // Constructor vacío

    public Grade(Long id, Alumno alumno, Long score) {
        this.id = id;
        this.alumno = alumno;
        this.score = score;
    }

    // Getters
    public Long getId() {
        return this.id;
    }

    public Alumno getAlumno() {
        return this.alumno;
    }

    public Long getScore() {
        return this.score;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setScore(Long score) {
        this.score = score;
    }

}
