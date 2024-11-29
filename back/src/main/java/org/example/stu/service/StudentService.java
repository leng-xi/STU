package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.*;
import org.example.stu.pojo.*;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HonourMapper honourMapper;
    @Autowired
    private StudentDetailMapper studentDetailMapper;

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Student> empList = studentMapper.selectAll();
        for (Student student : empList) {
            student.setPerson(personMapper.selectById(student.getPersonId()));
            student.setUser(userMapper.selectByPersonId(student.getPersonId()));
        }
        Page<Student> p = (Page<Student>) empList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }


    public boolean addStudent(Student student) {
        Person person=student.getPerson();
        User user=student.getUser();
        if(userMapper.selectByUsername(user)!=null)
            return false;
        personMapper.insertPerson(person);
        student.setPersonId(person.getId());
        user.setPersonId(person.getId());
        studentMapper.insert(student);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
        StudentDetail studentDetail=new StudentDetail();
        Honour honour=new Honour();
        studentDetail.setStudentId(student.getId());
        honour.setStudentId(student.getId());
        studentDetailMapper.insert(studentDetail);
        honourMapper.insert(honour);
        return true;
    }

    public boolean deletePerson(int personId) {

        return personMapper.deleteById(personId)>0;
    }

    public boolean updateStudent(Student student) {
        studentMapper.updateById(student);
        student.getUser().setUpdateTime(LocalDateTime.now());
        userMapper.updateById(student.getUser());
        personMapper.updateById(student.getPerson());
        return true;
    }
}
