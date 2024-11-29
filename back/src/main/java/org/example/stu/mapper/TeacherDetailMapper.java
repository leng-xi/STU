package org.example.stu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.TeacherDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 教师详细信息 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2024-10-21
 */
@Mapper
public interface TeacherDetailMapper extends BaseMapper<TeacherDetail>{
    @Select("select * from teacher_detail where teacher_id = #{teacherId}")
    TeacherDetail selectByTeacherId(int teacherId);
}
