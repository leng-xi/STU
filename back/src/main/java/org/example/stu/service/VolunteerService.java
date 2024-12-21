package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.VolunteerMapper;
import org.example.stu.mapper.StudentMapper;
import org.example.stu.pojo.Volunteer;
import org.example.stu.pojo.Innovation;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {
    @Autowired
    private VolunteerMapper volunteerMapper;
    @Autowired
    private StudentMapper studentMapper;

    public List<Volunteer> pageStudent(Integer studentId) {
        List<Volunteer> volunteerList = volunteerMapper.selectByStudentId(studentId);
        return volunteerList;
    }

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Volunteer> volunteerList = volunteerMapper.selectAll();
        Page<Volunteer> p = (Page<Volunteer>) volunteerList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }



    public boolean addVolunteer(Volunteer volunteer){
        try {
            int rowsAffected = volunteerMapper.insert(volunteer);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to add volunteer", e);
        }
    }

    public boolean deleteVolunteer(Volunteer volunteer){
        try {
            int rowsAffected = volunteerMapper.deleteById(volunteer.getId());
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to delete volunteer", e);
        }
    }

    public boolean updateVolunteer(Volunteer volunteer){
        try {
            int rowsAffected = volunteerMapper.updateById(volunteer);
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update volunteer", e);
        }
    }
}
