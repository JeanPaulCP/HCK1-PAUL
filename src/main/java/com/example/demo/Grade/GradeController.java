package com.example.demo.Grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/grade")
public class GradeController{
    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeRepository.findAll();
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        if (grade != null) {
            return new ResponseEntity<>(grade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        Grade savedGrade = gradeRepository.save(grade);
        return new ResponseEntity<>(savedGrade, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody Grade gradeDetails) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        if (grade != null) {
            grade.setAlumno(gradeDetails.getAlumno());
            grade.setScore(gradeDetails.getScore());
            Grade updatedGrade = gradeRepository.save(grade);
            return new ResponseEntity<>(updatedGrade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGrade(@PathVariable Long id) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        if (grade != null) {
            gradeRepository.delete(grade);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/alumno/{id}")
//    public ResponseEntity<List<String>> getAlumnoGrades(@PathVariable long id) {
//        // Supongamos que gradesRepository.findByAlumnoId devuelve la lista de calificaciones asociadas a ese id de alumno
//        List<Grade> gradesList = GradeRepository.findByAlumnoId(id);
//
//        // Aquí simplemente extraemos las calificaciones y las colocamos en una lista
//        List<String> gradeValues = gradesList.stream()
//                .map(Grade::getScore)  // Supongamos que el valor de la calificación está en el método getValue
//                .collect(Collectors.toList());
//
//        return new ResponseEntity<>(gradeValues, HttpStatus.OK);
//    }

}
