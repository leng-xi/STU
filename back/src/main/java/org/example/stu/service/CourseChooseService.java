package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.CourseChooseMapper;
import org.example.stu.pojo.CourseChoose;
import org.example.stu.pojo.Student;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseChooseService {
    @Autowired
    private CourseChooseMapper courseChooseMapper;

    public PageBean page(Integer page, Integer pageSize,Integer courseId) {
        PageHelper.startPage(page, pageSize);
        List<CourseChoose> courseChooseList = courseChooseMapper.selectAllByCourseId(courseId);
        Page<CourseChoose> p = (Page<CourseChoose>) courseChooseList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }





}
