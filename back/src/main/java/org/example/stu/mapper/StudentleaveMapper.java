
package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.example.stu.pojo.Studentleave;


import java.util.List;

@Mapper
public interface StudentleaveMapper extends BaseMapper<Studentleave> {
    @Select("select * from studentleave ")
    List<Studentleave> selectAll();

    @Select("select * from studentleave where approve_status = '批准成功' or approve_status = '批准失败' ")
    List<Studentleave> selectProcessedAll();


    @Select("select * from studentleave where student_id = #{studentId}")
    List<Studentleave> selectByStudentId(Integer studentId);

    @Select("select * from studentleave where teacher_id = #{teacherId}")
    List<Studentleave> selectByTeacherId(Integer teacherId);

    @Select("select * from studentleave where student_id = #{studentId} and ((start_data >= #{startData} and start_data <= #{endData}) or (end_data <= #{endData} and end_data >= #{startData}))")
    List<Studentleave> selectHaveStudentleave(Integer studentId,String startData,String endData);

    @Select("select * from studentleave where student_id = #{studentId} and ((start_data >= #{startData} and start_data <= #{endData}) or (end_data <= #{endData} and end_data >= #{startData})) and id != #{id} ")
    List<Studentleave> selectHaveUpdateStudentleave(Integer id,Integer studentId,String startData,String endData);

}
