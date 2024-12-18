package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.CourseChoose;
import org.example.stu.pojo.Student;

import java.util.List;

@Mapper
public interface CourseChooseMapper extends BaseMapper<CourseChoose> {
    @Select("select * from course_choose where course_id=#{courseId}")
    List<CourseChoose> selectAllByCourseId(Integer courseId);
    @Select("select * from course_choose where student_id=#{studentId}")
    List<CourseChoose> selectAllByStudentId(Integer studentId);
    @Select("select * from course_choose where student_id=#{studentId}")
    List<CourseChoose> selectByStudentId(Integer studentId);
    @Select("select * from course_choose where student_id=#{studentId} and course_id=#{courseId}")
    CourseChoose findByStuentIdAndCourseId(Integer studentId, Integer courseId);
    @Select("select * from course_choose where student_id=#{studentId} and course_id=#{courseId}")
    void deleteByStudentIdAndCourseId(CourseChoose courseChoose);
}
