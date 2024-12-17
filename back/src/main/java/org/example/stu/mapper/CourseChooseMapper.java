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
}
