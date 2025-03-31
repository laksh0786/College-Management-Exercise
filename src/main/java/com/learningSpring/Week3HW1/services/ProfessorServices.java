package com.learningSpring.Week3HW1.services;

import com.learningSpring.Week3HW1.entities.ProfessorEntity;
import com.learningSpring.Week3HW1.entities.StudentEntity;
import com.learningSpring.Week3HW1.repositories.ProfessorRepository;
import com.learningSpring.Week3HW1.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorServices {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    public ProfessorServices(ProfessorRepository professorRepository, StudentRepository studentRepository) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professor) {

        return professorRepository.save(professor);

    }

    public ProfessorEntity getProfessorById(Long professorId) {

        return professorRepository.findById(professorId).orElse(null);

    }

    public ProfessorEntity assignProfessorToStudent(Long professorId, Long studentId) {

        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return professorEntity.flatMap(professor -> studentEntity.map(student->{
            student.getProfessors().add(professor);
            studentRepository.save(student);
            professor.getStudents().add(student);
            return professor;
        })).orElse(null);

    }
}
