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
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private TeacherDetailMapper teacherDetailMapper;

    public PageBean page(Integer page, Integer pageSize, String input, String slect) {
        PageHelper.startPage(page, pageSize);
        List<Teacher> teacherList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        if (input.isEmpty()) {
            teacherList = teacherMapper.selectAll();
            for (Teacher teacher : teacherList) {
                teacher.setPerson(personMapper.selectById(teacher.getPersonId()));
            }
        } else if (slect.equals("1")) {
            teacherList= teacherMapper.selectLikeByName(input);
            for (Teacher teacher : teacherList) {
                teacher.setPerson(personMapper.selectById(teacher.getPersonId()));
            }
        } else if (slect.equals("2")) {
            teacherList= teacherMapper.selectLikeByUsername(input);
            for (Teacher teacher : teacherList) {
                teacher.setPerson(personMapper.selectById(teacher.getPersonId()));
            }
        } else if (slect.equals("3")) {
            teacherList = teacherMapper.selectLikeByTitle(input);
            for (Teacher teacher : teacherList) {
                teacher.setPerson(personMapper.selectById(teacher.getPersonId()));
            }
        } else if (slect.equals("4")) {
            teacherList = teacherMapper.selectLikeByDegree(input);
            for (Teacher teacher : teacherList) {
                teacher.setPerson(personMapper.selectById(teacher.getPersonId()));
            }
        }
        Page<Teacher> p = (Page<Teacher>) teacherList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }


    public boolean addTeacher(Teacher teacher) {
        Person p=teacher.getPerson();
        if (personMapper.selectByUsername(p.getUsername())!=null)return false;
        personMapper.insert(p);
        teacher.setPersonId(p.getId());
        teacherMapper.insert(teacher);
        TeacherDetail teacherDetail=new TeacherDetail();
        teacherDetail.setTeacherId(teacher.getId());
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
    public Integer getTeacherIdByCard(String teacherNum){
        Person per = personMapper.selectByUsername(teacherNum);
        Teacher tea = teacherMapper.selectByPersonId(per.getId());
        return tea.getId();
    }

    public String getTeacherNameByCard(String teacherNum){
        Person per = personMapper.selectByUsername(teacherNum);
        return per.getName();
    }
}
