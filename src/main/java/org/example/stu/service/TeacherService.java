package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.PersonMapper;
import org.example.stu.mapper.TeacherMapper;
import org.example.stu.mapper.UserMapper;
import org.example.stu.pojo.Person;
import org.example.stu.pojo.Teacher;
import org.example.stu.pojo.User;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private UserMapper userMapper;

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Teacher> empList = teacherMapper.selectAll();
        for (Teacher teacher : empList) {
            teacher.setPerson(personMapper.selectById(teacher.getPersonId()));
            teacher.setUser(userMapper.selectByPersonId(teacher.getPersonId()));
        }
        Page<Teacher> p = (Page<Teacher>) empList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }


    public boolean addTeacher(Teacher teacher) {
        Person person=teacher.getPerson();
        User user=teacher.getUser();
        if(userMapper.selectByUsername(user)!=null)
            return false;
        personMapper.insertPerson(person);
        teacher.setPersonId(person.getId());
        user.setPersonId(person.getId());
        teacherMapper.insert(teacher);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
        return true;
    }

    public boolean deletePerson(int personId) {
        return personMapper.deleteById(personId)>0;
    }

    public boolean updateTeacher
            (Teacher teacher) {
        teacherMapper.updateById(teacher);
        teacher.getUser().setUpdateTime(LocalDateTime.now());
        userMapper.updateById(teacher.getUser());
        personMapper.updateById(teacher.getPerson());
        return true;
    }
}
