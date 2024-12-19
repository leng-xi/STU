package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Socialpratice;

import java.util.List;

@Mapper
public interface SocialpraticeMapper extends BaseMapper<Socialpratice> {
    @Select("select * from socialpratice")
    List<Socialpratice> selectAll();

    @Select("select * from socialpratice where student_id = #{studentId}")
    List<Socialpratice> selectByStudentId(Integer studentId);


}
