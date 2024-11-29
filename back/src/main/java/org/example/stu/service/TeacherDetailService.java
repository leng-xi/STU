package org.example.stu.service;


import org.example.stu.mapper.StudentDetailMapper;
import org.example.stu.mapper.TeacherDetailMapper;
import org.example.stu.pojo.StudentDetail;
import org.example.stu.pojo.TeacherDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherDetailService{
    @Autowired
    private TeacherDetailMapper teacherDetailMapper;
    public TeacherDetail getTeacherDetail(int teacherId) {
        return teacherDetailMapper.selectByTeacherId(teacherId);
    }

    public void updateTeacherDetail(TeacherDetail teacherDetail) {
        teacherDetailMapper.updateById(teacherDetail);
    }
}
