package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Internship;

import java.util.List;

@Mapper
public interface InternshipMapper extends BaseMapper<Internship> {
    @Select("select * from internship")
    List<Internship> selectAll();

    @Select("select * from internship where student_id = #{studentId}")
    List<Internship> selectByStudentId(Integer studentId);


}
