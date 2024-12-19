package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.HonourMapper;
import org.example.stu.mapper.InnovationMapper;
import org.example.stu.mapper.StudentMapper;
import org.example.stu.pojo.Innovation;
import org.example.stu.pojo.Student;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InnovationService {

    @Autowired
    private InnovationMapper innovationMapper;
    @Autowired
    private StudentMapper studentMapper;

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Innovation> innovationList = innovationMapper.selectAll();
        Page<Innovation> p = (Page<Innovation>) innovationList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
  /*  public Object pageByStudentId(Integer page, Integer pageSize, Integer studentId) {
        PageHelper.startPage(page, pageSize);
        List<Innovation> innovationList = innovationMapper.selectByStudentId(studentId);
        for (Innovation innovation : innovationList) {
            innovation.setStudent(studentMapper.selectById(innovation.getStudentId()));
        }
        Page<Innovation> p = (Page<Innovation>) innovationList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }*/

    public boolean addInnovation(Innovation innovation){
        try {
            int rowsAffected = innovationMapper.insert(innovation);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to add innovation", e);
        }
    }

    public boolean deleteInnovation(Innovation innovation){
        try {
            int rowsAffected = innovationMapper.deleteById(innovation.getId());
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to delete innovation", e);
        }
    }

    public boolean updateInnovation(Innovation innovation){
        try {
            int rowsAffected = innovationMapper.updateById(innovation);
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update innovation", e);
        }
    }

}

