package org.example.stu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.User;

import java.util.Map;

@Mapper
public interface LoginMapper extends BaseMapper<User> {
    @Select("select * from user where username = #{username} and password = #{password}")
    Map<String,Object> selectByUsernameAndPassword(User user);
}
