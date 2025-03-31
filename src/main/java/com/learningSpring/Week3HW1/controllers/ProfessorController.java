package com.learningSpring.Week3HW1.controllers;

import com.learningSpring.Week3HW1.entities.ProfessorEntity;
import com.learningSpring.Week3HW1.services.ProfessorServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorServices professorServices;

    public ProfessorController(ProfessorServices professorServices) {
        this.professorServices = professorServices;
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professor) {

        return professorServices.createNewProfessor(professor);

    }


    @GetMapping("/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId){

        return professorServices.getProfessorById(professorId);

    }

    @PutMapping("/{professorId}/student/{studentId}")
    public ProfessorEntity assignProfessorToStudent(@PathVariable Long professorId,
                                                    @PathVariable Long studentId) {

        return professorServices.assignProfessorToStudent(professorId , studentId);

    }

}
