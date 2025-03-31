package com.learningSpring.Week3HW1.controllers;

import com.learningSpring.Week3HW1.entities.StudentEntity;
import com.learningSpring.Week3HW1.services.StudentServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity) {

        return studentServices.createNewStudent(studentEntity);

    }

    @GetMapping(path = "/{studentId}")
    public StudentEntity getStudentById(@PathVariable long studentId) {

        return studentServices.getStudentById(studentId);

    }


}
