package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Person;
import org.example.stu.service.LoginService;
import org.example.stu.utils.JwtUtils;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("")
    public Result login(@RequestBody Person person){
        log.info("login");
        Map<String,Object> form=loginService.login(person);
        if (form==null)Result.error("用户名或密码错误");
        return Result.success(form);
    }
}
