package com.example.crud.service;

import com.example.crud.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(int studentId);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int studentId);
}
