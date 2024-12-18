package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.*;
import org.example.stu.pojo.Course;
import org.example.stu.pojo.CourseChoose;
import org.example.stu.pojo.Person;
import org.example.stu.pojo.Student;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseChooseService {
    @Autowired
    private CourseChooseMapper courseChooseMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private UserMapper userMapper;

    public PageBean page1(Integer page, Integer pageSize,Integer courseId) {
        PageHelper.startPage(page, pageSize);
        List<CourseChoose> courseChooseList = courseChooseMapper.selectAllByCourseId(courseId);
        for (CourseChoose courseChoose : courseChooseList) {
            Person person = personMapper.selectById(studentMapper.selectById(courseChoose.getStudentId()).getPersonId());
            courseChoose.setStudentName(person.getName());
            courseChoose.setStudentNum(userMapper.selectByPersonId(person.getId()).getUsername());
            Course course = courseMapper.selectCourseNumAndCourseNameById(courseChoose.getCourseId());
            courseChoose.setCourseName(course.getCourseName());
            courseChoose.setCourseNum(course.getCourseNum());
        }
        Page<CourseChoose> p = (Page<CourseChoose>) courseChooseList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
    public PageBean page2(Integer page, Integer pageSize,Integer studentId) {
        PageHelper.startPage(page, pageSize);
        List<CourseChoose> courseChooseList = courseChooseMapper.selectAllByStudentId(studentId);
        for (CourseChoose courseChoose : courseChooseList) {
            Person person = personMapper.selectById(studentMapper.selectById(courseChoose.getStudentId()).getPersonId());
            courseChoose.setStudentName(person.getName());
            courseChoose.setStudentNum(userMapper.selectByPersonId(person.getId()).getUsername());
            Course course = courseMapper.selectCourseNumAndCourseNameById(courseChoose.getCourseId());
            courseChoose.setCourseName(course.getCourseName());
            courseChoose.setCourseNum(course.getCourseNum());
        }
        Page<CourseChoose> p = (Page<CourseChoose>) courseChooseList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
    public Integer addCourseChoose(CourseChoose courseChoose){
        if(courseMapper.selectById(courseChoose.getCourseId()).getIsopen()==0)return 0;
        List<CourseChoose> courseChooseList = courseChooseMapper.selectByStudentId(courseChoose.getStudentId());
        for (CourseChoose choose : courseChooseList) {
            if (choose.getCourseId().equals(courseChoose.getCourseId()))return 1;
        }
        courseChooseMapper.insert(courseChoose);
        return 2;
    }
    public Boolean addScore(CourseChoose courseChoose){
        CourseChoose courseChoose1 = courseChooseMapper.findByStuentIdAndCourseId(courseChoose.getStudentId(), courseChoose.getCourseId());
        if (courseChoose1!=null){return false;}
        Course course=courseMapper.selectById(courseChoose.getCourseId());
        int score3=courseChoose.getScore1()*Integer.parseInt(course.getPre1())+courseChoose.getScore2()*Integer.parseInt(course.getPre2());
        courseChoose.setScore3(score3/100);
        courseChooseMapper.updateById(courseChoose);
        return true;
    }

    public boolean delete(CourseChoose courseChoose) {
        courseChooseMapper.deleteByStudentIdAndCourseId(courseChoose);
        return true;
    }
}
