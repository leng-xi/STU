package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Volunteer;
import org.example.stu.service.StudentService;
import org.example.stu.service.VolunteerService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private StudentService studentService;
    @GetMapping("/getStudentVolunteerList")
    public Result getStudentVolunteerList(@RequestParam Integer studentId) {
        return Result.success(volunteerService.pageStudent(studentId));
    }

    @GetMapping("/getVolunteerList")
    public Result getVolunteerList(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        return Result.success(volunteerService.page(page, pageSize));
    }

    /*

    {
    "unit": "美团公司",
    "post": "外卖员",
    "studentId": 1,
    "startData":"123",
    "endData":"123",
    "certifier" : "苏浩",
    "evaluate" :"干得好"
    }
    */

    @PostMapping("/addVolunteer")
    public Result addVolunteer(@RequestBody Volunteer volunteer){
        String name = studentService.getStudentNameByCard(volunteer.getStudentNum());
        if(!name.equals(volunteer.getStudentName())){
            return Result.error("学生姓名与学号不匹配");

        }
        log.info("新增学生的志愿服务信息:{}",volunteer);
        if(!volunteerService.addVolunteer(volunteer)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    @PostMapping("/deleteVolunteer")
    public Result deleteVolunteer(@RequestBody Volunteer volunteer){
        log.info("删除志愿服务:{}",volunteer);
        if(volunteerService.deleteVolunteer(volunteer)){
            return Result.success();
        }
        return Result.error("删除失败");
    }

    @PostMapping("/updateVolunteer")
    public Result updateVolunteer(@RequestBody Volunteer volunteer){
        String name = studentService.getStudentNameByCard(volunteer.getStudentNum());
        if(!name.equals(volunteer.getStudentName())){
            return Result.error("学生姓名与学号不匹配");

        }
        log.info("更新志愿服务信息:{}",volunteer);
        if(!volunteerService.updateVolunteer(volunteer)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }
}