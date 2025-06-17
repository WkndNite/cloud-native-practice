CREATE TABLE IF NOT EXISTS score (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    score DOUBLE NOT NULL,
    created_at DATETIME,
    updated_at DATETIME,
    FOREIGN KEY (student_id) REFERENCES student(id)
);

-- 插入一些测试数据
INSERT INTO score (student_id, course_name, score, created_at, updated_at)
VALUES 
(1, '数学', 85.5, NOW(), NOW()),
(1, '语文', 92.0, NOW(), NOW()),
(1, '英语', 88.5, NOW(), NOW()),
(2, '数学', 78.0, NOW(), NOW()),
(2, '语文', 85.0, NOW(), NOW()),
(2, '英语', 90.0, NOW(), NOW()); 