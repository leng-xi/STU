package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Innovation;


import java.util.List;

@Mapper
public interface InnovationMapper extends BaseMapper<Innovation> {
    @Select("select * from innovation ")
    List<Innovation> selectAll();

    @Select("select * from innovation where student_id = #{studentId}")
    List<Innovation> selectByStudentId(Integer studentId);


}
