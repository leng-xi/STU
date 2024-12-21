package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.SocialpraticeMapper;
import org.example.stu.mapper.StudentMapper;
import org.example.stu.pojo.Socialpratice;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialpraticeService {
    @Autowired
    private SocialpraticeMapper socialpraticeMapper;
    @Autowired
    private StudentMapper studentMapper;

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Socialpratice> socialpraticeList = socialpraticeMapper.selectAll();
        Page<Socialpratice> p = (Page<Socialpratice>) socialpraticeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    public List<Socialpratice> pageStudent(Integer studentId) {
        List<Socialpratice> socialpraticeList = socialpraticeMapper.selectByStudentId(studentId);
        return socialpraticeList;
    }

    public boolean addSocialpratice(Socialpratice socialpratice){
        try {
            int rowsAffected = socialpraticeMapper.insert(socialpratice);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to add socialpratice", e);
        }
    }

    public boolean deleteSocialpratice(Socialpratice socialpratice){
        try {
            int rowsAffected = socialpraticeMapper.deleteById(socialpratice.getId());
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to delete socialpratice", e);
        }
    }

    public boolean updateSocialpratice(Socialpratice socialpratice){
        try {
            int rowsAffected = socialpraticeMapper.updateById(socialpratice);
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update socialpratice", e);
        }
    }
}
