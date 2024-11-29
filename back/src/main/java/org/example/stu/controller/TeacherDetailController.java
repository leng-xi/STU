package org.example.stu.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.StudentDetail;
import org.example.stu.pojo.TeacherDetail;
import org.example.stu.service.StudentDetailService;
import org.example.stu.service.TeacherDetailService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 教师详细信息 前端控制器
 * </p>
 *
 * @author 
 * @since 2024-10-21
 */
@Slf4j
@RestController
@RequestMapping("/teacherDetail")
public class TeacherDetailController {
    @Autowired
    private TeacherDetailService teacherDetailService;
    /*查询
    传入学生id*/
    @PostMapping("/getTeacherDetail")
    public Result getTeacherDetail(@RequestBody TeacherDetail teacherDetail){
        int teacherId = teacherDetail.getTeacherId();
        return Result.success(teacherDetailService.getTeacherDetail(teacherId));
    }
    @PostMapping("/updateTeacherDetail")
    public Result updateTeacherDetail(@RequestBody TeacherDetail teacherDetail){
        teacherDetailService.updateTeacherDetail(teacherDetail);
        return Result.success();
    }
}
