package com.example.stats.mapper;

import com.example.stats.model.CourseEnrollmentStats;
import com.example.stats.model.GradeDistribution;
import com.example.stats.model.StudentPerformance;

import java.util.List;
import java.util.Map;

public interface StatsMapper {
    // 获取成绩分布统计
    List<GradeDistribution> getGradeDistribution();

    // 获取指定课程的成绩分布
    List<GradeDistribution> getCourseGradeDistribution(Integer courseId);

    // 获取所有课程的选课和成绩统计
    List<CourseEnrollmentStats> getCourseEnrollmentStats();

    // 获取学生的学习表现统计
    List<StudentPerformance> getStudentPerformance();

    // 获取指定学生的学习表现
    StudentPerformance getStudentPerformanceById(Integer studentId);

    // 获取各专业平均成绩
    List<Map<String, Object>> getMajorAverageGrades();

    // 获取各年级平均成绩
    List<Map<String, Object>> getGradeLevelAverageGrades();
}
