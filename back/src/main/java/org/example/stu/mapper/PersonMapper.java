package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.Person;
@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    @Insert("insert into person(id, name, type, dept, card, gender, birthday, email, phone, address) values(#{id},#{name},#{type},#{dept},#{card},#{gender},#{birthday},#{email},#{phone},#{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insertPerson(Person person);

    @Select("select * from person where id = #{personId}")
    Person selectByPersonId(Integer personId);

    @Select("select * from person where username = #{username} and password = #{password}")
    Person selectByUsernameAndPassword(Person person);

    @Select("select * from person where username = #{username}")
    Person selectByUsername(String username);
    @Select("select * from person where card = #{card}")
    Person selectByCard(String card);
}
