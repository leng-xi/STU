package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where person_id = #{personId}")
    User selectByPersonId(int personId);
    @Select("select * from user where username = #{username}")
    User selectByUsername(User user);
}
