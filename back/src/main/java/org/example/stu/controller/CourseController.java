package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Course;
import org.example.stu.service.CourseService;
import org.example.stu.utils.PageBean;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourseList")
    public Result getCourseList(@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer pageSize
    )
    {
        log.info("分页查询 page={},pageSize={}", page, pageSize);
        PageBean pageBean = courseService.page(page, pageSize);
        return Result.success(pageBean);
    }
    @PostMapping("/addCourse")
    public Result addCourse(@RequestBody Course course){
        log.info("新增课程信息:{}",course);
        if(!courseService.addCourse(course)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }
    @PostMapping("/deleteCourse")
    public Result deleteCourse(@RequestBody Course course){
        int courseId = course.getId();
        log.info("删除课程id:{}",courseId);
        if(courseService.deleteCourse(courseId)){
            return Result.success();
        }
        return Result.error("删除失败");
    }
    @PostMapping("/updateCourse")
    public Result updateCourse(@RequestBody Course course){
        log.info("更新课程信息:{}",course);
        if(!courseService.updateCourse(course)){
                return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }
}
