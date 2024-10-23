package org.example.stu.service;

import org.example.stu.mapper.HonourMapper;
import org.example.stu.pojo.Honour;
import com.baomidou.mybatisplus.extension.service.IService;
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

    public Honour getHonour(int studentId) {
        return honourMapper.selectByStudentId(studentId);

    }

    public void updateHonour(Honour honour) {
        honourMapper.updateById(honour);
    }
}
