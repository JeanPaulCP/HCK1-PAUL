package com.example.demo.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        if (alumno != null) {
            return new ResponseEntity<>(alumno, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
        Alumno savedAlumno = alumnoRepository.save(alumno);
        return new ResponseEntity<>(savedAlumno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumnoDetails) {
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        if (alumno != null) {
            alumno.setLastName(alumnoDetails.getLastName());
            alumno.setCode(alumnoDetails.getCode());
            Alumno updatedAlumno = alumnoRepository.save(alumno);
            return new ResponseEntity<>(updatedAlumno, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable Long id) {
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        if (alumno != null) {
            alumnoRepository.delete(alumno);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}