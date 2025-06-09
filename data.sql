-- 创建数据库
CREATE DATABASE IF NOT EXISTS cloud_student_ms CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE cloud_student_ms;

-- 创建 student 表
CREATE TABLE student (
    student_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender ENUM('男','女') DEFAULT '男',
    birth_date DATE,
    major VARCHAR(100) DEFAULT '计算机科学与技术',
    grade_level ENUM('大一','大二','大三','大四') DEFAULT '大一',
    email VARCHAR(100),
    phone_number VARCHAR(20),
    address VARCHAR(200),
    nationality VARCHAR(50),
    enrollment_year YEAR,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 创建 teacher 表
CREATE TABLE teacher (
    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender ENUM('男','女') DEFAULT '男',
    email VARCHAR(100),
    phone_number VARCHAR(20),
    department VARCHAR(100) DEFAULT '计算机学院',
    office_location VARCHAR(100),
    hire_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 创建 course 表
CREATE TABLE course (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    credit DECIMAL(3,1) DEFAULT 3.0,
    teacher_id INT,
    semester VARCHAR(50),
    course_type ENUM('必修','选修'),
    classroom_location VARCHAR(100),
    course_description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
);

-- 创建 enrollment 表（去掉enrollment_status，enrollment_id自增，添加创建和修改时间）
CREATE TABLE enrollment (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    grade DECIMAL(5,2) NOT NULL,
    enrolled_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id),
    UNIQUE KEY unique_student_course (student_id, course_id)  -- 保证一个学生对一个课程只有一条记录
);

-- 插入 student 数据
INSERT INTO student (student_id, name, gender, birth_date, major, grade_level, email, phone_number, address, nationality, enrollment_year) VALUES
(100001, '张无忌', '男', '2003-05-10', '计算机科学与技术', '大三', 'zhangwuji@example.com', '13800000001', '北京市海淀区', '中国', 2021),
(100002, '赵敏', '女', '2004-08-15', '计算机科学与技术', '大二', 'zhaomin@example.com', '13800000002', '北京市朝阳区', '中国', 2022),
(100003, '周芷若', '女', '2003-09-20', '计算机科学与技术', '大三', 'zhouzhiruo@example.com', '13800000003', '上海市浦东新区', '中国', 2021),
(100004, '令狐冲', '男', '2002-11-30', '计算机科学与技术', '大四', 'linghuchong@example.com', '13800000004', '江苏省南京市', '中国', 2020),
(100005, '任盈盈', '女', '2004-02-25', '计算机科学与技术', '大二', 'renyingying@example.com', '13800000005', '浙江省杭州市', '中国', 2022),
(100006, '郭靖', '男', '2003-04-01', '计算机科学与技术', '大三', 'guojing@example.com', '13800000006', '山东省青岛市', '中国', 2021),
(100007, '黄蓉', '女', '2004-07-10', '计算机科学与技术', '大二', 'huangrong@example.com', '13800000007', '广东省深圳市', '中国', 2022),
(100008, '杨过', '男', '2002-12-15', '计算机科学与技术', '大四', 'yangguo@example.com', '13800000008', '四川省成都市', '中国', 2020),
(100009, '小龙女', '女', '2004-03-18', '计算机科学与技术', '大二', 'xiaolongnv@example.com', '13800000009', '重庆市', '中国', 2022),
(100010, '乔峰', '男', '2002-06-05', '计算机科学与技术', '大四', 'qiaofeng@example.com', '13800000010', '辽宁省大连市', '中国', 2020),
(100011, '段誉', '男', '2003-07-22', '计算机科学与技术', '大三', 'duanyu@example.com', '13800000011', '云南省大理市', '中国', 2021),
(100012, '王语嫣', '女', '2004-09-12', '计算机科学与技术', '大二', 'wangyuyan@example.com', '13800000012', '湖南省长沙市', '中国', 2022),
(100013, '虚竹', '男', '2002-10-08', '计算机科学与技术', '大四', 'xuzhu@example.com', '13800000013', '湖北省武汉市', '中国', 2020),
(100014, '狄云', '男', '2003-02-17', '计算机科学与技术', '大三', 'diyun@example.com', '13800000014', '陕西省西安市', '中国', 2021),
(100015, '袁承志', '男', '2004-01-30', '计算机科学与技术', '大二', 'yuanchengzhi@example.com', '13800000015', '福建省厦门市', '中国', 2022),
(100016, '梵高', '男', '2003-03-30', '计算机科学与技术', '大三', 'vangogh@example.com', '13800000016', '阿姆斯特丹', '荷兰', 2021),
(100017, '拉斐尔', '男', '2004-04-06', '计算机科学与技术', '大二', 'raphael@example.com', '13800000017', '罗马', '意大利', 2022),
(100018, '达·芬奇', '男', '2002-05-02', '计算机科学与技术', '大四', 'davinci@example.com', '13800000018', '佛罗伦萨', '意大利', 2020),
(100019, '牛顿', '男', '2003-01-04', '计算机科学与技术', '大三', 'newton@example.com','13800000019' ,'伦敦', '英国', 2021),
(100020, '爱因斯坦', '男', '2004-06-14', '计算机科学与技术', '大二', 'einstein@example.com','13800000020', '慕尼黑', '德国', 2022);

-- 插入 teacher 数据
INSERT INTO teacher (name, gender, email, phone_number, department, office_location, hire_date) VALUES
('王老师', '男', 'wanglaoshi@example.com', '13900000001', '计算机学院', '办公楼201', '2015-09-01'),
('李老师', '女', 'lilaoshi@example.com', '13900000002', '计算机学院', '办公楼202', '2016-09-01'),
('赵老师', '男', 'zhaolaoshi@example.com', '13900000003', '计算机学院', '办公楼203', '2014-09-01'),
('钱老师', '女', 'qianlaoshi@example.com', '13900000004', '计算机学院', '办公楼204', '2017-09-01'),
('孙老师', '男', 'sunlaoshi@example.com', '13900000005', '计算机学院', '办公楼205', '2013-09-01'),
('周老师', '女', 'zhoulaoshi@example.com', '13900000006', '计算机学院', '办公楼206', '2018-09-01');

-- 插入 course 数据
INSERT INTO course (course_name, credit, teacher_id, semester, course_type, classroom_location, course_description) VALUES
('计算机导论', 3.0, 1, '2023-2024-1', '必修', '教学楼101', '计算机科学基础课程'),
('数据结构', 4.0, 2, '2023-2024-1', '必修', '教学楼102', '数据结构与算法基础'),
('操作系统', 3.5, 3, '2023-2024-1', '必修', '教学楼103', '操作系统原理'),
('数据库系统', 3.0, 4, '2023-2024-1', '必修', '教学楼104', '数据库设计与实现'),
('计算机网络', 3.0, 5, '2023-2024-1', '必修', '教学楼105', '计算机网络基础'),
('软件工程', 2.5, 6, '2023-2024-1', '选修', '教学楼106', '软件开发过程与管理'),
('人工智能导论', 3.0, 1, '2023-2024-2', '选修', '教学楼107', '人工智能基础'),
('机器学习', 3.5, 2, '2023-2024-2', '选修', '教学楼108', '机器学习算法'),
('数据挖掘', 3.0, 3, '2023-2024-2', '选修', '教学楼109', '数据分析与挖掘技术'),
('计算机视觉', 3.0, 4, '2023-2024-2', '选修', '教学楼110', '图像处理与计算机视觉');

-- 插入 enrollment 数据，保证所有学生对所有课程都有记录，成绩先设置为0，稍后更新
INSERT INTO enrollment (student_id, course_id, grade)
SELECT s.student_id, c.course_id, 0.0
FROM student s CROSS JOIN course c;

-- 更新 enrollment 表中的 grade，模拟成绩分布
-- 创建临时表存放随机数
CREATE TEMPORARY TABLE temp_rand AS
SELECT enrollment_id, RAND() AS rand_val FROM enrollment;

-- 更新成绩
UPDATE enrollment e
JOIN temp_rand t ON e.enrollment_id = t.enrollment_id
SET e.grade = FLOOR(
    CASE
        WHEN t.rand_val < 0.2 THEN FLOOR(RAND() * 60)            -- 0-59 不及格 20%
        WHEN t.rand_val < 0.4 THEN FLOOR(RAND() * 10) + 60       -- 60-69 及格 20%
        WHEN t.rand_val < 0.7 THEN FLOOR(RAND() * 10) + 70       -- 70-79 中等 30%
        WHEN t.rand_val < 0.9 THEN FLOOR(RAND() * 10) + 80       -- 80-89 良好 20%
        ELSE FLOOR(RAND() * 11) + 89                             -- 90-100 优秀 10%
    END
);

-- 删除临时表
DROP TEMPORARY TABLE temp_rand;
