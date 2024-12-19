package org.example.stu.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.stu.pojo.Course;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseChooseVo {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Integer score1;
    private Integer score2;
    private Integer score3;
    private Course course;
}