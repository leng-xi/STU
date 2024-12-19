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
    private HonourMapper honourMapper;
    @Autowired
    private StudentDetailMapper studentDetailMapper;

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Student> studentList = studentMapper.selectAll();
        for (Student student : studentList) {
            student.setPerson(personMapper.selectById(student.getPersonId()));
        }
        Page<Student> p = (Page<Student>) studentList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
    public boolean addStudent(Student student) {
        Person p=student.getPerson();
        if (personMapper.selectByUsername(p.getUsername())!=null)return false;
        personMapper.insert(p);
        student.setPersonId(p.getId());
        studentMapper.insert(student);
        StudentDetail studentDetail=new StudentDetail();
        Honour honour=new Honour();
        studentDetail.setStudentId(student.getId());
        studentDetailMapper.insert(studentDetail);
        honourMapper.insert(honour);
        return true;
    }

    public boolean deletePerson(int personId) {
        return personMapper.deleteById(personId)>0;
    }

    public boolean updateStudent(Student student) {
        studentMapper.updateById(student);
        personMapper.updateById(student.getPerson());
        return true;
    }
    public Integer getStudentIdByCard(String studentNum){
        Person per = personMapper.selectByCard(studentNum);
        Student stu = studentMapper.selectByPersonId(per.getId());
        return stu.getId();
    }

    public String getStudentNameByCard(String studentNum){
        Person per = personMapper.selectByCard(studentNum);
        return per.getName();
    }
}
