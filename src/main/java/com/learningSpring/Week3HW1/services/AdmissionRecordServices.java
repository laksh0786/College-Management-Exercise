package com.learningSpring.Week3HW1.services;

import com.learningSpring.Week3HW1.entities.AdmissionRecordEntity;
import com.learningSpring.Week3HW1.entities.StudentEntity;
import com.learningSpring.Week3HW1.repositories.AdmissionRecordRepository;
import com.learningSpring.Week3HW1.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class AdmissionRecordServices {

    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentRepository studentRepository;

    public AdmissionRecordServices(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentRepository = studentRepository;
    }

    public AdmissionRecordEntity createAdmissionRecord(AdmissionRecordEntity admissionRecordEntity, Long id) {

        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);

        if(studentEntity == null) {
            return null;
        }

        admissionRecordEntity.setStudent(studentEntity);

        return admissionRecordRepository.save(admissionRecordEntity);

    }

    public AdmissionRecordEntity getAdmissionRecordById(long recordId) {

        return admissionRecordRepository.findById(recordId).orElse(null);

    }

}
