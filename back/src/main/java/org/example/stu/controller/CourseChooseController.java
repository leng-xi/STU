package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Course;
import org.example.stu.pojo.CourseChoose;
import org.example.stu.pojo.Teacher;
import org.example.stu.service.CourseChooseService;
import org.example.stu.service.CourseService;
import org.example.stu.utils.PageBean;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/courseChoose")
public class CourseChooseController {
    @Autowired
    private CourseChooseService courseChooseService;

    /*拿到某一个课程的选课列表
    * score1 平时成绩
    * score2 作业成绩
    * score3 考试成绩
    * score4 总成绩
    *
    * */
    @GetMapping("/getCourseChooseListFromCourse")
    public Result getCourseChooseListFromCourse(@RequestParam(defaultValue = "1") Integer page,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                Integer courseId
    ) {
        log.info("分页查询 page={},pageSize={},courseId={}", page, pageSize, courseId);
        PageBean pageBean = courseChooseService.page1(page, pageSize, courseId);
        return Result.success(pageBean);
    }

    @GetMapping("/getCourseChooseListFromStudent")
    public Result getCourseChooseListFromStudent(@RequestParam(defaultValue = "1") Integer page,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                Integer studentId
    ) {
        log.info("分页查询 page={},pageSize={},studentId={}", page, pageSize, studentId);
        PageBean pageBean = courseChooseService.page2(page, pageSize, studentId);
        return Result.success(pageBean);
    }
    /*传入学生id,课程id
    *
    *
    *
    *
    * */
    @PostMapping("/addCourseChoose")
    public Result addCourseChoose(@RequestBody CourseChoose courseChoose){
        log.info("courseChoose:{}",courseChoose);
        if(courseChooseService.addCourseChoose(courseChoose)==0){
            return Result.error("未开课");
        }
        if(courseChooseService.addCourseChoose(courseChoose)==1){
            return Result.error("已存在");
        }
        return Result.success("添加成功");
    }
    @PostMapping("/addScore")
    public Result addScore(@RequestBody CourseChoose courseChoose){
        log.info("courseChoose:{}",courseChoose);
        if(!courseChooseService.addScore(courseChoose)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody CourseChoose courseChoose){
        log.info("courseChoose:{}",courseChoose);
        if(courseChooseService.delete(courseChoose)){
            return Result.success();
        }
        return Result.error("删除失败");
    }
}
