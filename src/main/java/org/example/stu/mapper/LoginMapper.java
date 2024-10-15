package org.example.stu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.stu.pojo.User;

import java.util.Map;

@Mapper
public interface LoginMapper {
    @Select("select * from user")
    public Map<String,Object> selectByUsernameAndPassword(User user);
}
