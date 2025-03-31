package com.learningSpring.Week3HW1.services;

import com.learningSpring.Week3HW1.entities.ProfessorEntity;
import com.learningSpring.Week3HW1.entities.StudentEntity;
import com.learningSpring.Week3HW1.entities.SubjectEntity;
import com.learningSpring.Week3HW1.repositories.ProfessorRepository;
import com.learningSpring.Week3HW1.repositories.StudentRepository;
import com.learningSpring.Week3HW1.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectServices {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    public SubjectServices(SubjectRepository subjectRepository, StudentRepository studentRepository, ProfessorRepository professorRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
    }

    public SubjectEntity createNewSubject(SubjectEntity subject) {

        return subjectRepository.save(subject);

    }

    public SubjectEntity getSubjectById(Long subjectId) {

        return subjectRepository.findById(subjectId).orElse(null);

    }

    public SubjectEntity assignStudentToSubject(Long subjectId, Long studentId) {

        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return subjectEntity.flatMap(subject -> studentEntity.map(student -> {
            subject.getStudents().add(student);
            return subjectRepository.save(subject);
        })).orElse(null);

    }

    public SubjectEntity assignProfessorToSubject(Long subjectId, Long professorId) {

        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);

        return professorEntity.flatMap(professor -> subjectEntity.map(
                subject -> {
                    subject.setProfessor(professor);
                    return subjectRepository.save(subject);
                }
        )).orElse(null);

    }
}
