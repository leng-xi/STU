package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Student;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select("select * from student")
    List<Student> selectAll();
    @Select("select * from student where person_id=#{id}")
    Student selectByPersonId(Integer id);

    @Select("select * from student where major like concat('%',#{input},'%')")
    List<Student> selectLikeByMajor(String input);

    @Select("select * from student where class_name like concat('%',#{input},'%')")
    List<Student> selectLikeByClass(String input);
    @Select("select * from person left join student on person.id=student.person_id where person.name like concat('%',#{input},'%')and type=3 ")
    List<Student> selectLikeByName(String input);
    @Select("select * from person left join student on person.id=student.person_id where person.username like concat('%',#{input},'%')and type=3")
    List<Student> selectLikeByUsername(String input);
}
