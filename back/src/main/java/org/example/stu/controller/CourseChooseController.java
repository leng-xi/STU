package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Course;
import org.example.stu.service.CourseChooseService;
import org.example.stu.service.CourseService;
import org.example.stu.utils.PageBean;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseChooseController {
    @Autowired
    private CourseChooseService courseChooseService;

    //拿到某一个课程的选课列表
    @GetMapping("/getCourseChooseListFromCourse")
    public Result getCourseChooseListFromCourse(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize,Integer courseId
    ) {
        log.info("分页查询 page={},pageSize={},courseNum={}", page, pageSize,courseId);
        PageBean pageBean = courseChooseService.page(page, pageSize,courseId);
        return Result.success(pageBean);
    }

}
