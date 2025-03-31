package com.learningSpring.Week3HW1.services;

import com.learningSpring.Week3HW1.entities.StudentEntity;
import com.learningSpring.Week3HW1.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

    private final StudentRepository studentRepository;

    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity createNewStudent(StudentEntity studentEntity) {

        return studentRepository.save(studentEntity);

    }


    public StudentEntity getStudentById(Long id){

        return studentRepository.findById(id).orElse(null);

    }

}
