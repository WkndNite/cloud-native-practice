package com.example.stats.client;

import com.example.stats.model.CourseEnrollmentStats;
import com.example.stats.model.GradeDistribution;
import com.example.stats.model.StudentPerformance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@FeignClient(name = "stats-service")
public interface StatsClient {

    @GetMapping("/stats/grade-distribution")
    List<GradeDistribution> getGradeDistribution();

    @GetMapping("/stats/course/{courseId}/grade-distribution")
    List<GradeDistribution> getCourseGradeDistribution(@PathVariable("courseId") Integer courseId);

    @GetMapping("/stats/course-enrollment")
    List<CourseEnrollmentStats> getCourseEnrollmentStats();

    @GetMapping("/stats/student-performance")
    List<StudentPerformance> getStudentPerformance();

    @GetMapping("/stats/student/{studentId}/performance")
    StudentPerformance getStudentPerformanceById(@PathVariable("studentId") Integer studentId);

    @GetMapping("/stats/major-average-grades")
    List<Map<String, Object>> getMajorAverageGrades();

    @GetMapping("/stats/grade-level-average-grades")
    List<Map<String, Object>> getGradeLevelAverageGrades();
}
