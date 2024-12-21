
package org.example.stu.service;

import org.example.stu.mapper.HonourMapper;
import org.example.stu.pojo.Honour;
import org.example.stu.pojo.Honour;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.stu.pojo.Innovation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人荣誉 服务类
 * </p>
 *
 * @author leng-xi
 * @since 2024-10-19
 */
@Service
public class HonourService {
    @Autowired
    private HonourMapper honourMapper;

    public List<Honour> pageStudent(Integer studentId) {
        List<Honour> honourList = honourMapper.selectByStudentId(studentId);
        return honourList;
    }

    public List<Honour> getAllHonours() {
        return honourMapper.selectAll();
    }

    public List<Honour> getHonour(int studentId) {
        return honourMapper.selectByStudentId(studentId);

    }


    public boolean addHonour(Honour honour) {
        return honourMapper.insert(honour) > 0;
    }

    public boolean deleteHonour(Honour honour) {
        return honourMapper.deleteById(honour.getId()) > 0;
    }

    public boolean updateHonour(Honour honour) {
        honourMapper.updateById(honour);
        return true;
    }
}