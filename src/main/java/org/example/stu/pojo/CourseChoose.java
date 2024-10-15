package org.example.stu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseChoose {
    private int courseChooseId;
    private Student student;
    private Course course;
}
