package org.example.stu.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.StudentDetail;
import org.example.stu.service.StudentDetailService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 学生详细信息 前端控制器
 * </p>
 *
 * @author leng-xi
 * @since 2024-10-19
 */
@Slf4j
@RestController
@RequestMapping("/studentDetail")
public class StudentDetailController {
    @Autowired
    private StudentDetailService studentDetailService;
    /*查询
    传入学生id*/
    @PostMapping("/getStudentDetail")
    public Result getStudentDetail(@RequestBody StudentDetail studentDetail){
        int studentId = studentDetail.getStudentId();
        return Result.success(studentDetailService.getStudentDetail(studentId));
    }
    @PostMapping("/updateStudentDetail")
    public Result updateStudentDetail(@RequestBody StudentDetail studentDetail){
        studentDetailService.updateStudentDetail(studentDetail);
        return Result.success();
    }
}
