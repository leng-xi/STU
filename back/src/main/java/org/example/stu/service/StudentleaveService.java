package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.example.stu.mapper.StudentMapper;
import org.example.stu.mapper.StudentleaveMapper;
import org.example.stu.mapper.TeacherMapper;
import org.example.stu.pojo.Internship;
import org.example.stu.pojo.Studentleave;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentleaveService {
    @Autowired
    private StudentleaveMapper studentleaveMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;



    public List<Studentleave> pageStudent(Integer studentId) {
        List<Studentleave> studentleaveList = studentleaveMapper.selectByStudentId(studentId);
        return studentleaveList;
    }
    public PageBean pageStudent(Integer page, Integer pageSize,Integer studentId) {
        PageHelper.startPage(page, pageSize);
        List<Studentleave> studentleaveList = studentleaveMapper.selectByStudentId(studentId);
        Page<Studentleave> p = (Page<Studentleave>) studentleaveList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Studentleave> studentleaveList = studentleaveMapper.selectAll();
        Page<Studentleave> p = (Page<Studentleave>) studentleaveList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    public PageBean processedPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Studentleave> studentleaveList = studentleaveMapper.selectProcessedAll();
        Page<Studentleave> p = (Page<Studentleave>) studentleaveList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }



    public boolean addStudentleave(Studentleave studentleave){
        studentleave.setApproveStatus("未批准");
        try {
            int rowsAffected = studentleaveMapper.insert(studentleave);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to add studentleave", e);
        }
    }

    public boolean deleteStudentleave(Studentleave studentleave){
        try {
            int rowsAffected = studentleaveMapper.deleteById(studentleave.getId());
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to delete studentleave", e);
        }
    }

    public boolean updateStudentleave(Studentleave studentleave){
        studentleave.setApproveStatus("未批准");
        try {
            int rowsAffected = studentleaveMapper.updateById(studentleave);
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update studentleave", e);
        }
    }
    public boolean approveStudentleave(Studentleave studentleave){
        studentleave.setApproveStatus("批准成功");
        try {
            int rowsAffected = studentleaveMapper.updateById(studentleave);
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update studentleave", e);
        }
    }

    public boolean rejectStudentleave(Studentleave studentleave){
        studentleave.setApproveStatus("批准失败");
        try {
            int rowsAffected = studentleaveMapper.updateById(studentleave);
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update studentleave", e);
        }
    }
    public boolean haveStudentleave(Integer studentId,String startData,String endData){
        List<Studentleave> studentleaves = studentleaveMapper.selectHaveStudentleave(studentId,startData,endData);
        return studentleaves.size() > 0;
    }

    public boolean haveUpdateStudentleave(Integer id,Integer studentId,String startData,String endData){
        List<Studentleave> studentleaves = studentleaveMapper.selectHaveUpdateStudentleave(id,studentId,startData,endData);
        return studentleaves.size() > 0;
    }

}