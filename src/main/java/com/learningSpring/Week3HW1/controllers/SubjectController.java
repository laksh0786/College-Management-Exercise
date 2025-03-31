package com.learningSpring.Week3HW1.controllers;

import com.learningSpring.Week3HW1.entities.SubjectEntity;
import com.learningSpring.Week3HW1.services.SubjectServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/subjects")
public class SubjectController {

    private final SubjectServices subjectServices;

    public SubjectController(final SubjectServices subjectServices) {
        this.subjectServices = subjectServices;
    }

    @PostMapping
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subject){

        return subjectServices.createNewSubject(subject);

    }

    @GetMapping("/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId){

        return subjectServices.getSubjectById(subjectId);

    }

    @PutMapping(path = "/{subjectId}/student/{studentId}")
    public SubjectEntity assignStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId){

        return subjectServices.assignStudentToSubject(subjectId , studentId);

    }

    @PutMapping(path = "/{subjectId}/professor/{professorId}")
    public SubjectEntity assignProfessorToSubject(@PathVariable Long subjectId, @PathVariable Long professorId){

        return subjectServices.assignProfessorToSubject(subjectId , professorId);

    }


}
