package com.example.crud.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.crud.model.Student;

@FeignClient(name = "crud-service")
public interface CRUDServiceClient {

    @GetMapping("/students")
    List<Student> getAllStudents();

    @GetMapping("/students/{id}")
    Student getStudentById(@PathVariable("id") int studentId);

    @PostMapping("/students")
    void addStudent(@RequestBody Student student);

    @PutMapping("/students/{id}")
    void updateStudent(@PathVariable("id") int studentId, @RequestBody Student student);

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable("id") int studentId);

    @GetMapping("/port")
    String getPort();

    @GetMapping("/fallback")
    String fallback();
}
