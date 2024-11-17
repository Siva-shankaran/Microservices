package com.project.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    Result findByRollNumber(int rollNumber);
}
