package com.example.scoreclient.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Score {
    private Integer enrollmentId;
    private Integer studentId;
    private Integer courseId;
    private Double grade;
    private LocalDateTime enrolledAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // 关联查询的额外字段
    private String studentName;
    private String courseName;
    private String courseType;
    private Double credit;

    // Getters
    public Integer getEnrollmentId() { return enrollmentId; }
    public Integer getStudentId() { return studentId; }
    public Integer getCourseId() { return courseId; }
    public Double getGrade() { return grade; }
    public LocalDateTime getEnrolledAt() { return enrolledAt; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public String getStudentName() { return studentName; }
    public String getCourseName() { return courseName; }
    public String getCourseType() { return courseType; }
    public Double getCredit() { return credit; }

    // Setters
    public void setEnrollmentId(Integer enrollmentId) { this.enrollmentId = enrollmentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
    public void setGrade(Double grade) { this.grade = grade; }
    public void setEnrolledAt(LocalDateTime enrolledAt) { this.enrolledAt = enrolledAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setCourseType(String courseType) { this.courseType = courseType; }
    public void setCredit(Double credit) { this.credit = credit; }
} 