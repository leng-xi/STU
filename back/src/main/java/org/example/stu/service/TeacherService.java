package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.PersonMapper;
import org.example.stu.mapper.TeacherDetailMapper;
import org.example.stu.mapper.TeacherMapper;
import org.example.stu.pojo.*;
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
    private TeacherDetailMapper teacherDetailMapper;

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Teacher> empList = teacherMapper.selectAll();
        for (Teacher teacher : empList) {
            teacher.setPerson(personMapper.selectById(teacher.getPersonId()));
        }
        Page<Teacher> p = (Page<Teacher>) empList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }


    public boolean addTeacher(Teacher teacher) {
        Person p = teacher.getPerson();
        if (personMapper.selectByUsername(p.getUsername()) != null) return false;
        personMapper.insert(p);
        teacherMapper.insert(teacher);
        TeacherDetail teacherDetail = new TeacherDetail();
        Honour honour = new Honour();
        teacherDetailMapper.insert(teacherDetail);
        return true;
    }

    public boolean deletePerson(int personId) {
        return personMapper.deleteById(personId) > 0;
    }

    public boolean updateTeacher
            (Teacher teacher) {
        teacherMapper.updateById(teacher);
        personMapper.updateById(teacher.getPerson());
        return true;
    }
}
