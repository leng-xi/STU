package org.example.stu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("course_choose")
public class CourseChoose {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Integer score1;
    private Integer score2;
    private Integer score3;
    @TableField(exist = false)
    private Course course;
    @TableField(exist = false)
    private Student student;
    @TableField(exist = false)
    private Person person;
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
