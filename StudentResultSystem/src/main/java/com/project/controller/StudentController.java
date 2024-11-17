package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.Entity.Student;
import com.project.Repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        studentRepository.save(student);

        // Prepare data to send to Result Service
        Map<String, Object> request = new HashMap<>();
        request.put("rollNumber", student.getRollNumber());
        request.put("marks", student.getMarks());

        // Communicate with Result Service
        String resultServiceUrl = "http://localhost:8081/results/calculate";
        restTemplate.postForObject(resultServiceUrl, request, String.class);

        return student;
    }


    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
