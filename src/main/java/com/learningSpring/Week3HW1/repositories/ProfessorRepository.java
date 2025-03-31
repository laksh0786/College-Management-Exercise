package com.learningSpring.Week3HW1.repositories;

import com.learningSpring.Week3HW1.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity ,Long> {
}
