package org.example.stu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("course")
public class Course {
    private Integer id;
    private String courseName;
    private String courseNum;
    private String openingUnit;
    private Integer totalHours;
    private String credits;
    private String courseType;
    private String time;
    private String place;
    private Integer term;
    private Integer teacherId;
    private String teacherName;
    private String teacherNum;
    private String pre1;
    private String pre2;
    private String pre3;
}