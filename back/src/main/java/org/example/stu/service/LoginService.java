package org.example.stu.service;

import org.example.stu.mapper.PersonMapper;
import org.example.stu.mapper.StudentMapper;
import org.example.stu.mapper.TeacherMapper;
import org.example.stu.pojo.Person;
import org.example.stu.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    public Map<String,Object> login(Person p) {
        Person person = personMapper.selectByUsernameAndPassword(p);
        if(person==null){return null;}
        Map<String,Object> form = new HashMap<>();
        form.put("personId",person.getId());
        form.put("username",person.getUsername());
        form.put("type",person.getType());
        if(person.getType()==3){
            form.put("studentId",studentMapper.selectByPersonId(person.getId()).getId());
        }else if(person.getType()==2){
            form.put("teacherId",teacherMapper.selectByPersonId(person.getId()).getId());
        }
        String jwt= JwtUtils.generateJwt(form);
        form.put("jwt",jwt);
        return form;
    }
}
