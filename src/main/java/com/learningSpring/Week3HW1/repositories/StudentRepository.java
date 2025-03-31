package com.learningSpring.Week3HW1.repositories;

import com.learningSpring.Week3HW1.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity , Long> {
}
