package org.example.stu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Honour;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 个人荣誉 Mapper 接口
 * </p>
 *
 * @author leng-xi
 * @since 2024-10-19
 */
@Mapper
public interface HonourMapper extends BaseMapper<Honour> {
    @Select("select * from honour where student_id = #{studentId}")
    Honour selectByStudentId(int studentId);
}
