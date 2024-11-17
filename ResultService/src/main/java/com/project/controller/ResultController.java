package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.Entity;

import com.project.StudentDTO;
import com.project.entity.Result;
import com.project.repositary.ResultRepository;

@RestController
@RequestMapping("/results")
public class ResultController {
    @Autowired
    private ResultRepository resultRepository;

    @PostMapping
    public Result calculateResult(@RequestBody StudentDTO student) {
        String status = (student.getMarks() >= 40) ? "Pass" : "Fail";
        Result result = new Result();
        result.setRollNumber(student.getRollNumber());
        result.setStatus(status);
        return resultRepository.save(result);
    }

    @GetMapping("/{rollNumber}")
    public Result getResult(@PathVariable int rollNumber) {
        return resultRepository.findByRollNumber(rollNumber);
    }
}
