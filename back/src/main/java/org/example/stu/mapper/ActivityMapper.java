package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Activity;
import org.example.stu.pojo.Studentleave;

import java.util.List;

@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {
    @Select("select * from activity order by start_data desc ")
    List<Activity> selectAll();

    @Select("select * from activity where approve_status = '批准成功' or approve_status = '批准失败' ")
    List<Activity> selectProcessedAll();

    @Select("select * from activity where student_id = #{studentId}")
    List<Activity> selectByStudentId(Integer studentId);

    @Select("select * from studentleave where teacher_id = #{teacherId}")
    List<Activity> selectByTeacherId(Integer teacherId);
}