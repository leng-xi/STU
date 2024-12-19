package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Volunteer;

import java.util.List;

@Mapper
public interface VolunteerMapper extends BaseMapper<Volunteer> {
    @Select("select * from volunteer")
    List<Volunteer> selectAll();

    @Select("select * from volunteer where student_id = #{studentId}")
    List<Volunteer> selectByStudentId(Integer studentId);


}
