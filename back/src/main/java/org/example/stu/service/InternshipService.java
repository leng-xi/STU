package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.InternshipMapper;
import org.example.stu.mapper.StudentMapper;
import org.example.stu.pojo.Internship;
import org.example.stu.pojo.Innovation;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService {
    @Autowired
    private InternshipMapper internshipMapper;
    @Autowired
    private StudentMapper studentMapper;
    public List<Internship> pageStudent(Integer studentId) {
        List<Internship> internshipList = internshipMapper.selectByStudentId(studentId);
        return internshipList;
    }


    public List<Internship> page() {

        List<Internship> internshipList = internshipMapper.selectAll();

        return internshipList;
    }



    public boolean addInternship(Internship internship){
        try {
            int rowsAffected = internshipMapper.insert(internship);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to add internship", e);
        }
    }

    public boolean deleteInternship(Internship internship){
        try {
            int rowsAffected = internshipMapper.deleteById(internship.getId());
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to delete internship", e);
        }
    }

    public boolean updateInternship(Internship internship){
        try {
            int rowsAffected = internshipMapper.updateById(internship);
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update internship", e);
        }
    }
}