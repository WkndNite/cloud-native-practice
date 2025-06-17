package com.example.stats.model;

import lombok.Data;

@Data
public class GradeDistribution {
    private String gradeRange;
    private Integer count;
    private Double percentage;
}
