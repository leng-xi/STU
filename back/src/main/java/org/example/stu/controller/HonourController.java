package org.example.stu.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Honour;
import org.example.stu.pojo.StudentDetail;
import org.example.stu.service.HonourService;
import org.example.stu.service.StudentDetailService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 个人荣誉 前端控制器
 * </p>
 *
 * @author leng-xi
 * @since 2024-10-19
 */
@Slf4j
@RestController
@RequestMapping("/honour")
public class HonourController {
    @Autowired
    private HonourService honourService;
    /*查询
    传入学生id*/
    @PostMapping("/getHonour")
    public Result getHonour(@RequestBody Honour honour){
        int studentId = honour.getStudentId();
        return Result.success(honourService.getHonour(studentId));
    }
    @PostMapping("/updateHonour")
    public Result updateHonour(@RequestBody Honour honour){
        honourService.updateHonour(honour);
        return Result.success();
    }
}
