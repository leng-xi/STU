package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.ContestMapper;
import org.example.stu.mapper.StudentMapper;
import org.example.stu.pojo.Contest;
import org.example.stu.pojo.Innovation;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {
    @Autowired
    private ContestMapper contestMapper;
    @Autowired
    private StudentMapper studentMapper;


    public List<Contest> pageStudent(Integer studentId) {
        List<Contest> contestList = contestMapper.selectByStudentId(studentId);
        return contestList;
    }
    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Contest> contestList = contestMapper.selectAll();
        Page<Contest> p = (Page<Contest>) contestList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }



    public boolean addContest(Contest contest){
        try {
            int rowsAffected = contestMapper.insert(contest);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to add contest", e);
        }
    }

    public boolean deleteContest(Contest contest){
        try {
            int rowsAffected = contestMapper.deleteById(contest.getId());
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to delete contest", e);
        }
    }

    public boolean updateContest(Contest contest){
        try {
            int rowsAffected = contestMapper.updateById(contest);
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update contest", e);
        }
    }
}

