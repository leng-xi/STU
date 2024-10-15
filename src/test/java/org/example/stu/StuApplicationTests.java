package org.example.stu;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.stu.mapper.LoginMapper;
import org.example.stu.pojo.User;
import org.example.stu.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class StuApplicationTests {
@Autowired
    private LoginMapper loginMapper;

    @Test
    public void test(){
        User user = new User();
        user.setPassword("132");
        user.setUsername("123");

        loginMapper.selectByUsernameAndPassword(user);
    }
    @Test
    public void test02(){
        Map<String,Object> map = new HashMap<>();
        map.put("username","123");
        map.put("password","132");
        String token = JwtUtils.generateJwt(map);
        System.out.println(token);
    }
}
