package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.example.stu.pojo.Person;
@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    @Insert("insert into person(id, name, type, dept, card, gender, birthday, email, phone, address) values(#{id},#{name},#{type},#{dept},#{card},#{gender},#{birthday},#{email},#{phone},#{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insertPerson(Person person);
}
