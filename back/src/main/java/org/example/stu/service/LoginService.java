package org.example.stu.service;

import org.example.stu.mapper.LoginMapper;
import org.example.stu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    public Map<String,Object> login(User user) {
        return loginMapper.selectByUsernameAndPassword(user);
    }
}
