package org.example.stu.mapper;

import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Person;
import org.example.stu.pojo.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student")
    List<Student> selectAll();
    @Select("select * from person where person_id = #{personId}")
    Person selectPersonById(int personId);
    @Delete("delete from person where person_id = #{personId}")
    boolean deletePerson(int personId);
}
