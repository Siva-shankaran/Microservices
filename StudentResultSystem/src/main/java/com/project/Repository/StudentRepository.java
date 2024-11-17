package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
