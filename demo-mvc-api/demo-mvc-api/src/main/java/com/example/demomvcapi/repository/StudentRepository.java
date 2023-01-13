package com.example.demomvcapi.repository;

import com.example.demomvcapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
