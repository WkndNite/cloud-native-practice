package com.example.scoreclient.model;

import java.util.List;
import lombok.Data;

@Data
public class ScoreReport {
    private Integer studentId;
    private String studentName;
    private List<Score> scores;
    private Double averageScore;
    private Double totalScore;
    private Integer courseCount;
    private Double highestScore;
    private Double lowestScore;

    // Getters
    public Integer getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public List<Score> getScores() { return scores; }
    public Double getAverageScore() { return averageScore; }
    public Double getTotalScore() { return totalScore; }
    public Integer getCourseCount() { return courseCount; }
    public Double getHighestScore() { return highestScore; }
    public Double getLowestScore() { return lowestScore; }

    // Setters
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setScores(List<Score> scores) { this.scores = scores; }
    public void setAverageScore(Double averageScore) { this.averageScore = averageScore; }
    public void setTotalScore(Double totalScore) { this.totalScore = totalScore; }
    public void setCourseCount(Integer courseCount) { this.courseCount = courseCount; }
    public void setHighestScore(Double highestScore) { this.highestScore = highestScore; }
    public void setLowestScore(Double lowestScore) { this.lowestScore = lowestScore; }
} 