package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Student;
import org.example.stu.pojo.Teacher;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Select("select * from teacher")
    List<Teacher> selectAll();
    @Select("select * from teacher where person_id=#{id}")
    Teacher selectByPersonId(Integer id);
    @Select("select * from teacher where title like concat('%',#{input},'%')")
    List<Teacher> selectLikeByTitle(String input);

    @Select("select * from teacher where degree like concat('%',#{input},'%')")
    List<Teacher> selectLikeByDegree(String input);
    @Select("select * from person left join teacher on person.id=teacher.person_id where person.name like concat('%',#{input},'%')and type=2 ")
    List<Teacher> selectLikeByName(String input);
    @Select("select * from person left join teacher on person.id=teacher.person_id where person.username like concat('%',#{input},'%')and type=2")
    List<Teacher> selectLikeByUsername(String input);


}
