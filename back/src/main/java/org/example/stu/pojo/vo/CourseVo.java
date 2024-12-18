package org.example.stu.pojo.vo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseVo {
    private Integer id;
    private String courseName;
    private String courseNum;
    private String openingUnit;
    private Integer totalHours;
    private String credits;
    private String courseType;
    private Integer time;
    private String place;
    private Integer term;
    private Integer teacherId;
    private String teacherName;
    private String teacherNum;
    private Integer isopen;
    private String pre1;
    private String pre2;
}