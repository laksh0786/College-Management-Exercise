package com.learningSpring.Week3HW1.controllers;

import com.learningSpring.Week3HW1.entities.AdmissionRecordEntity;
import com.learningSpring.Week3HW1.services.AdmissionRecordServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admission-records")
public class AdmissionRecordController {

    private final AdmissionRecordServices admissionRecordServices;

    public AdmissionRecordController(AdmissionRecordServices admissionRecordServices) {
        this.admissionRecordServices = admissionRecordServices;
    }

    @PostMapping("/student/{studentId}")
    public AdmissionRecordEntity createAdmissionRecord(@RequestBody AdmissionRecordEntity admissionRecordEntity,
                                                       @PathVariable Long studentId) {

        return admissionRecordServices.createAdmissionRecord(admissionRecordEntity, studentId);

    }

    @GetMapping("/{recordId}")
    public AdmissionRecordEntity getAdmissionRecord(@PathVariable long recordId) {

        return admissionRecordServices.getAdmissionRecordById(recordId);

    }


}
