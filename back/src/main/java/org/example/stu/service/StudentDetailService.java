package org.example.stu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.stu.mapper.StudentDetailMapper;
import org.example.stu.pojo.StudentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 学生详细信息 服务类
 * </p>
 *
 * @author leng-xi
 * @since 2024-10-19
 */
@Service
public class StudentDetailService  {
@Autowired
private StudentDetailMapper studentDetailMapper;
    public StudentDetail getStudentDetail(int studentId) {
        return studentDetailMapper.selectByStudentId(studentId);
    }

    public void updateStudentDetail(StudentDetail studentDetail) {
        studentDetailMapper.updateById(studentDetail);
    }
}
