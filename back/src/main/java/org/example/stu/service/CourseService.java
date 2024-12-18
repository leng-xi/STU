package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.CourseMapper;
import org.example.stu.mapper.PersonMapper;
import org.example.stu.mapper.TeacherMapper;
import org.example.stu.mapper.UserMapper;
import org.example.stu.pojo.*;
import org.example.stu.pojo.vo.CourseVo;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PersonMapper personMapper;

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Course> courseList = courseMapper.selectAll();
        for (Course course : courseList) {
            CourseVo courseVo = new CourseVo(course.getId(), course.getCourseName(), course.getCourseNum(), course.getOpeningUnit(), course.getTotalHours(), course.getCredits(), course.getCourseType(), course.getTime(), course.getPlace(), course.getTerm(), course.getTeacherId(), "", "", course.getIsopen(), course.getPre1(), course.getPre2());
            Teacher teacher = teacherMapper.selectById(courseVo.getTeacherId());
            if (teacher != null) {
                Person person= personMapper.selectById(teacher.getPersonId());
                User user = userMapper.selectByPersonId(person.getId());
                courseVo.setTeacherNum(person.getName());
                courseVo.setTeacherName(user.getUsername());
                courseVo.setTeacherName(person.getName());
            }
        }
        Page<Course> p = (Page<Course>) courseList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    public boolean addCourse(Course course) {
        return courseMapper.insert(course) > 0;
    }

    public boolean deleteCourse(int courseId) {
        return courseMapper.deleteById(courseId) > 0;
    }

    public boolean updateCourse(Course course) {
        courseMapper.updateById(course);
        return true;
    }
}
