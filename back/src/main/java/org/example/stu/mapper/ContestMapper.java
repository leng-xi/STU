package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Contest;

import java.util.List;

@Mapper
public interface ContestMapper extends BaseMapper<Contest> {
    @Select("select * from contest")
    List<Contest> selectAll();

    @Select("select * from contest where student_id = #{studentId}")
    List<Contest> selectByStudentId(Integer studentId);


}
