package com.springbootrestcurdstudent.com.springbootrestcurdstudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestcurdstudent.com.springbootrestcurdstudent.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
