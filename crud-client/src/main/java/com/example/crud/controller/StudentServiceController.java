package com.example.crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.client.CRUDServiceClient;
import com.example.crud.model.Student;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/client/students")
@RequiredArgsConstructor
public class StudentServiceController {

    private final CRUDServiceClient studentServiceClient;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentServiceClient.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentServiceClient.getStudentById(id);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentServiceClient.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student) {
        studentServiceClient.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentServiceClient.deleteStudent(id);
    }
}
