package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Internship;
import org.example.stu.service.InternshipService;
import org.example.stu.service.StudentService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/internship")
public class InternshipController {

    @Autowired
    private InternshipService internshipService;

    @Autowired
    private StudentService studentService;
    @GetMapping("/getStudentInternshipList")
    public Result getStudentInternshipList(@RequestParam Integer studentId) {
        return Result.success(internshipService.pageStudent(studentId));
    }

    @GetMapping("/getInternshipList")
    public Result getInternshipList() {
        return Result.success(internshipService.page());
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

    @PostMapping("/addInternship")
    public Result addInternship(@RequestBody Internship internship){
        String name = studentService.getStudentNameByCard(internship.getStudentNum());
        if(name == null)return Result.error("学生学号不存在");
        if(internship.getStudentName()==null||internship.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(internship.getStudentNum()==null||internship.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(!name.equals(internship.getStudentName())){
            return Result.error("学生姓名与学号不匹配");
        }

        Integer studentId = studentService.getStudentIdByCard(internship.getStudentNum());
        internship.setStudentId(studentId);
        if(internship.getUnit()==null)return Result.error("实习单位输入不合法");
        if(internship.getPost()==null)return Result.error("实习岗位输入不合法");
        if(internship.getStartData()==null)return Result.error("实习开始时间输入不合法");
        if(internship.getEndData()==null)return Result.error("实习结束时间输入不合法");
        if(internship.getStartData().compareTo(internship.getEndData())>0)return Result.error("实习开始时间不能晚于实习结束时间");
        if(internship.getEndData().compareTo(toString(LocalDate.now()))>0) return Result.error("实习结束时间不应该晚于今天");
        if(internship.getCertifier()==null)return Result.error("实习证明人输入不合法");
        if(internship.getEvaluate()==null)return Result.error("实习评价输入不合法");

        log.info("新增学生的校外实习信息:{}",internship);
        if(!internshipService.addInternship(internship)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    private String toString(LocalDate now) {
        return now.toString();
    }

    @PostMapping("/deleteInternship")
    public Result deleteInternship(@RequestBody Internship internship){
        log.info("删除校外实习:{}",internship);
        if(internshipService.deleteInternship(internship)){
            return Result.success();
        }
        return Result.error("删除失败");
    }

    @PostMapping("/updateInternship")
    public Result updateInternship(@RequestBody Internship internship){
        String name = studentService.getStudentNameByCard(internship.getStudentNum());
        if(!name.equals(internship.getStudentName())){
            return Result.error("学生姓名与学号不匹配");

        }
        log.info("更新校外实习信息:{}",internship);
        if(!internshipService.updateInternship(internship)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }
}