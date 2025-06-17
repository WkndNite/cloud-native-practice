package com.example.stats.controller;

import com.example.stats.client.StatsClient;
import com.example.stats.model.CourseEnrollmentStats;
import com.example.stats.model.GradeDistribution;
import com.example.stats.model.StudentPerformance;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client/stats")
public class StatsClientController {
    
    @Autowired
    private StatsClient statsClient;

    @GetMapping("/grade-distribution")
    @CircuitBreaker(name = "statsCB", fallbackMethod = "getGradeDistributionFallback")
    public List<GradeDistribution> getGradeDistribution() {
        return statsClient.getGradeDistribution();
    }

    @GetMapping("/course/{courseId}/grade-distribution")
    @CircuitBreaker(name = "statsCB", fallbackMethod = "getCourseGradeDistributionFallback")
    public List<GradeDistribution> getCourseGradeDistribution(@PathVariable Integer courseId) {
        return statsClient.getCourseGradeDistribution(courseId);
    }

    @GetMapping("/course-enrollment")
    @CircuitBreaker(name = "statsCB", fallbackMethod = "getCourseEnrollmentStatsFallback")
    public List<CourseEnrollmentStats> getCourseEnrollmentStats() {
        return statsClient.getCourseEnrollmentStats();
    }

    @GetMapping("/student-performance")
    @CircuitBreaker(name = "statsCB", fallbackMethod = "getStudentPerformanceFallback")
    public List<StudentPerformance> getStudentPerformance() {
        return statsClient.getStudentPerformance();
    }

    @GetMapping("/student/{studentId}/performance")
    @CircuitBreaker(name = "statsCB", fallbackMethod = "getStudentPerformanceByIdFallback")
    public StudentPerformance getStudentPerformanceById(@PathVariable Integer studentId) {
        return statsClient.getStudentPerformanceById(studentId);
    }

    @GetMapping("/major-average-grades")
    @CircuitBreaker(name = "statsCB", fallbackMethod = "getMajorAverageGradesFallback")
    public List<Map<String, Object>> getMajorAverageGrades() {
        return statsClient.getMajorAverageGrades();
    }

    @GetMapping("/grade-level-average-grades")
    @CircuitBreaker(name = "statsCB", fallbackMethod = "getGradeLevelAverageGradesFallback")
    public List<Map<String, Object>> getGradeLevelAverageGrades() {
        return statsClient.getGradeLevelAverageGrades();
    }

    // Fallback methods
    public List<GradeDistribution> getGradeDistributionFallback(Throwable t) {
        return Collections.emptyList();
    }

    public List<GradeDistribution> getCourseGradeDistributionFallback(Integer courseId, Throwable t) {
        return Collections.emptyList();
    }

    public List<CourseEnrollmentStats> getCourseEnrollmentStatsFallback(Throwable t) {
        return Collections.emptyList();
    }

    public List<StudentPerformance> getStudentPerformanceFallback(Throwable t) {
        return Collections.emptyList();
    }

    public StudentPerformance getStudentPerformanceByIdFallback(Integer studentId, Throwable t) {
        return new StudentPerformance();
    }

    public List<Map<String, Object>> getMajorAverageGradesFallback(Throwable t) {
        return Collections.emptyList();
    }

    public List<Map<String, Object>> getGradeLevelAverageGradesFallback(Throwable t) {
        return Collections.emptyList();
    }
}
