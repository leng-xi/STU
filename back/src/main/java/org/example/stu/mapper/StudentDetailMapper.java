package org.example.stu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.stu.pojo.StudentDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 学生详细信息 Mapper 接口
 * </p>
 *
 * @author leng-xi
 * @since 2024-10-19
 */
@Mapper
public interface StudentDetailMapper extends BaseMapper<StudentDetail> {
    @Select("select * from student_detail where student_id = #{studentId}")
    StudentDetail selectByStudentId(int studentId);
}
