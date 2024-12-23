package org.example.stu.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
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
    @TableField(exist = false)
    private Integer num1;
    @TableField(exist = false)
    private Integer num2;
    @TableField(exist = false)
    private Integer num3;
    @TableField(exist = false)
    private Integer num4;
    @TableField(exist = false)
    private Integer num5;
}