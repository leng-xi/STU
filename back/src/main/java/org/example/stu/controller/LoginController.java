package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Person;
import org.example.stu.service.LoginService;
import org.example.stu.service.StudentService;
import org.example.stu.service.TeacherService;
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
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @PostMapping("")
    public Result login(@RequestBody Person person){
        log.info("login");
        Map<String,Object> form=loginService.login(person);
        if (form==null)Result.error("用户名或密码错误");
        return Result.success(form);
    }
    @GetMapping("/register")
    public Result register(@RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "") String password,
                           @RequestParam(defaultValue = "") String type,
                           @RequestParam(defaultValue = "") String username){
        log.info("register");
        if(type.equals("student")){
            boolean register = studentService.register(name, password, username);
            if(!register){
                return Result.error("用户名已存在");
            }
        }
        if(type.equals("teacher")){
            boolean register = studentService.register(name, password, username);
            if(!register){
                return Result.error("用户名已存在");
            }
        }
        return Result.success("注册成功");
    }
}
