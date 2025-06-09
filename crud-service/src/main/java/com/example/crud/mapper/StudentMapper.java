package com.example.crud.mapper;

import com.example.crud.model.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getAllStudents();

    Student getStudentById(int studentId);

    int insertStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(int studentId);
}
