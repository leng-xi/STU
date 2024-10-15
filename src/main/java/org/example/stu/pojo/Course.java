package org.example.stu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private int courseId;
    private String courseName;
    private String courseNum;
    private String openingUnit;
    private int totalHours;
    private double credit;
    private String courseType;
    private int[] time;
    private String place;
    private Teacher teacher;
    private int teacherId;

}
