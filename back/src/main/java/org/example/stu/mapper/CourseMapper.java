package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Course;
import org.example.stu.pojo.Student;

import java.util.List;
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    @Select("select * from course")
    List<Course> selectAll();

    @Select("select * from course where course_num=#{courseNum}")
    Course selectByCourseNum(Course course);

    @Select("select course_name,course_num from course where id=#{courseId}")
    Course selectCourseNumAndCourseNameById(Integer courseId);
}
