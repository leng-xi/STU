package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.StudentMapper;
import org.example.stu.pojo.Student;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Student> empList = studentMapper.selectAll();
        for (Student student : empList) {
            student.setPerson(studentMapper.selectPersonById(student.getPersonId()));
        }
        Page<Student> p = (Page<Student>) empList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }


    public void addStudent(Student student) {
        /*studentMapper.insertStudent(student);*/
    }

    public boolean deletePerson(int personId) {
        return studentMapper.deletePerson(personId);
    }
}
