package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.User;
import org.example.stu.service.LoginService;
import org.example.stu.utils.JwtUtils;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("")
    public Result login(@RequestBody User user){
        log.info("login");
        Map<String,Object> m=loginService.login(user);
        if (m!=null){
            Map<String,Object> form = new HashMap<>();
            form.put("personId",m.get("person_id"));
            form.put("username",m.get("username"));
            form.put("type",m.get("type"));
            String jwt= JwtUtils.generateJwt(form);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
