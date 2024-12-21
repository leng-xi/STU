package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.*;
import org.example.stu.pojo.*;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public PageBean page(Integer page, Integer pageSize, String input, String slect) {
        PageHelper.startPage(page, pageSize);
        List<Student> studentList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        if (input.isEmpty()) {
            studentList = studentMapper.selectAll();
            for (Student student : studentList) {
                student.setPerson(personMapper.selectById(student.getPersonId()));
            }
        } else if (slect.equals("1")) {
            studentList= studentMapper.selectLikeByName(input);
            for (Student student : studentList) {
                student.setPerson(personMapper.selectById(student.getPersonId()));
            }
        } else if (slect.equals("2")) {
            studentList= studentMapper.selectLikeByUsername(input);
            for (Student student : studentList) {
                student.setPerson(personMapper.selectById(student.getPersonId()));
            }
        } else if (slect.equals("3")) {
            studentList = studentMapper.selectLikeByMajor(input);
            for (Student student : studentList) {
                student.setPerson(personMapper.selectById(student.getPersonId()));
            }
        } else if (slect.equals("4")) {
            studentList = studentMapper.selectLikeByClass(input);
            for (Student student : studentList) {
                student.setPerson(personMapper.selectById(student.getPersonId()));
            }
        }
        Page<Student> p = (Page<Student>) studentList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    public boolean addStudent(Student student) {
        Person p = student.getPerson();
        if (personMapper.selectByUsername(p.getUsername()) != null) return false;
        personMapper.insert(p);
        student.setPersonId(p.getId());
        studentMapper.insert(student);
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setStudentId(student.getId());
        studentDetailMapper.insert(studentDetail);
        return true;
    }

    public boolean deletePerson(int personId) {
        return personMapper.deleteById(personId) > 0;
    }

    public boolean updateStudent(Student student) {
        Person temp = personMapper.selectByUsername(student.getPerson().getUsername());
        if(temp!=null){
            if (temp.getId() != student.getPerson().getId()) {
                return false;
            }
        }
        studentMapper.updateById(student);
        personMapper.updateById(student.getPerson());
        return true;
    }

    public Integer getStudentIdByCard(String studentNum){
        Person per = personMapper.selectByUsername(studentNum);
        Student stu = studentMapper.selectByPersonId(per.getId());
        return stu.getId();
    }

    public String getStudentNameByCard(String studentNum){
        Person per = personMapper.selectByUsername(studentNum);
        return per.getName();
    }

    public String getStudentNumById(Integer studentId){
        Student student = studentMapper.selectById(studentId);
        return student.getPerson().getUsername();
    }




    public Student getList(Integer id) {
        Student student = studentMapper.selectById(id);
        student.setStudentDetail(studentDetailMapper.selectByStudentId(id));
        student.setPerson(personMapper.selectById(student.getPersonId()));
        return student;
    }

    public boolean password(String personId, String old, String newp) {
        Person person = personMapper.selectById(Integer.parseInt(personId));
        if(!person.getPassword().equals(old))return false;
        person.setPassword(newp);
        personMapper.updateById(person);
        return true;
    }
}
