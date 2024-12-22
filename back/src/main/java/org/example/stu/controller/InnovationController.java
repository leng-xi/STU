package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Innovation;
import org.example.stu.service.InnovationService;
import org.example.stu.service.StudentService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/innovation")
public class InnovationController {

    @Autowired
    private InnovationService innovationService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentInnovationList")
    public Result getStudentInnovationList(@RequestParam Integer studentId) {
        return Result.success(innovationService.pageStudent(studentId));
    }

    @GetMapping("/getInnovationList")
    public Result getInnovationList(
    ) {

        return Result.success(innovationService.page());
    }




    /*
    "id": 1,
    "name": "1",
    "studentId": 1,
    "tutor":"chen zhi yong",
    "student":{"id": 1,
    "major": "1",
    "className": "1",
    "personId": 1,
    "user": {
        "id": 1,
        "password": "111",
        "username": "111",
        "personId": 1
    },
    "person": {
        "id": 1,
        "name": "张三",
        "type": 1,
        "dept": "1",
        "card": null,
        "gender": 1,
        "birthday": null,
        "email": null,
        "phone": null,
        "address": null
    }}
    "data1" : "1999-12-1"
    "data2" :"1999-12-2"
    * */
    //添加创新项目
    @PostMapping("/addInnovation")
    public Result addInnovation(@RequestBody Innovation innovation){
        String name = studentService.getStudentNameByCard(innovation.getStudentNum());
        if(name == null)return Result.error("学生学号不存在");
        if(innovation.getStudentName()==null||innovation.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(innovation.getStudentNum()==null||innovation.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(!name.equals(innovation.getStudentName())){
            return Result.error("学生姓名与学号不匹配");
        }
        Integer studentId = studentService.getStudentIdByCard(innovation.getStudentNum());
        innovation.setStudentId(studentId);
        if(innovation.getContent() == null)return Result.error("项目内容输入不合法");
        if(innovation.getData1() == null)return Result.error("项目开始时间输入不合法");
        if(innovation.getData2() == null)return Result.error("项目结束时间输入不合法");
        if(innovation.getData1().compareTo(innovation.getData2())>0)return Result.error("项目开始时间不能早于项目结束时间");
        if(innovation.getData2().compareTo(toString(LocalDate.now()))>0) return Result.error("项目结束时间不应该晚于今天");
        if(innovation.getProject() == null)return Result.error("项目名称输入不合法");
        if(innovation.getTutor() == null)return Result.error("指导老师输入不合法");
        log.info("新增学生的创业项目信息:{}",innovation);
        if(!innovationService.addInnovation(innovation)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    private String toString(LocalDate now) {
        return now.toString();
    }

    @PostMapping("/deleteInnovation")
    public Result deleteInnovation(@RequestBody Innovation innovation){
        log.info("删除创新项目id:{}",innovation);
        if(innovationService.deleteInnovation(innovation)){
            return Result.success();
        }
        return Result.error("删除失败");
    }

    @PostMapping("/updateInnovation")
    public Result updateInnovation(@RequestBody Innovation innovation){
        String name = studentService.getStudentNameByCard(innovation.getStudentNum());
        if(!name.equals(innovation.getStudentName())){
            return Result.error("学生姓名与学号不匹配");

        }
        log.info("更新创新项目信息:{}",innovation);
        if(!innovationService.updateInnovation(innovation)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }
}