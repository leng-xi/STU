package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.CourseMapper;
import org.example.stu.pojo.Course;
import org.example.stu.pojo.Student;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Course> courseList = courseMapper.selectAll();
        Page<Course> p = (Page<Course>) courseList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    public boolean addCourse(Course course) {
        if(courseMapper.selectByCourseNum(course)!=null)
            return false;
        return false;
    }
    public boolean deleteCourse(int courseId) {
        return courseMapper.deleteById(courseId)>0;
    }
    public boolean updateCourse(Course course) {
        courseMapper.updateById(course);
        return true;
    }
}
