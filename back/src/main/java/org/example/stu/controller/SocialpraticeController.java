package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Socialpratice;
import org.example.stu.service.SocialpraticeService;
import org.example.stu.service.StudentService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/socialpratice")
public class SocialpraticeController {

    @Autowired
    private SocialpraticeService socialpraticeService;

    @Autowired
    private StudentService studentService;


    @GetMapping("/getStudentSocialpraticeList")
    public Result getStudentSocialpraticeList(@RequestParam Integer studentId) {
        return Result.success(socialpraticeService.pageStudent(studentId));
    }

    @GetMapping("/getSocialpraticeList")
    public Result getSocialpraticeList(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        return Result.success(socialpraticeService.page(page, pageSize));
    }

    /*
     *
     *
     * */

    //添加创新项目
    @PostMapping("/addSocialpratice")
    public Result addSocialpratice(@RequestBody Socialpratice socialpratice){
        String name = studentService.getStudentNameByCard(socialpratice.getStudentNum());
        if(name == null)return Result.error("学生学号不存在");
        if(socialpratice.getStudentName()==null||socialpratice.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(socialpratice.getStudentNum()==null||socialpratice.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(!name.equals(socialpratice.getStudentName())){
            return Result.error("学生姓名与学号不匹配");
        }
        Integer studentId = studentService.getStudentIdByCard(socialpratice.getStudentNum());
        socialpratice.setStudentId(studentId);
        if(socialpratice.getUnit()==null)return Result.error("社会实践单位输入不合法");
        if(socialpratice.getStartData()==null)return Result.error("社会实践开始时间输入不合法");
        if(socialpratice.getEndData()==null)return Result.error("社会实践结束时间输入不合法");
        if(socialpratice.getStartData().compareTo(socialpratice.getEndData())>0)return Result.error("社会实践开始时间不能早于社会实践结束时间");
        if(socialpratice.getEndData().compareTo(toString(LocalDate.now()))>0) return Result.error("社会实践结束时间不应该晚于今天");
        if(socialpratice.getCertifier()==null)return Result.error("社会实践证明人输入不合法");
        if(socialpratice.getEvaluate()==null)return Result.error("社会实践评价输入不合法");

        log.info("新增学生的社会实践信息:{}",socialpratice);
        if(!socialpraticeService.addSocialpratice(socialpratice)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    private String toString(LocalDate now) {
        return now.toString();
    }

    @PostMapping("/deleteSocialpratice")
    public Result deleteSocialpratice(@RequestBody Socialpratice socialpratice){
        log.info("删除社会实践:{}",socialpratice);
        if(socialpraticeService.deleteSocialpratice(socialpratice)){
            return Result.success();
        }
        return Result.error("删除失败");
    }

    @PostMapping("/updateSocialpratice")
    public Result updateSocialpratice(@RequestBody Socialpratice socialpratice){
        String name = studentService.getStudentNameByCard(socialpratice.getStudentNum());
        if(name == null)return Result.error("学生学号不存在");
        if(socialpratice.getStudentName()==null||socialpratice.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(socialpratice.getStudentNum()==null||socialpratice.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(!name.equals(socialpratice.getStudentName())){
            return Result.error("学生姓名与学号不匹配");
        }
        Integer studentId = studentService.getStudentIdByCard(socialpratice.getStudentNum());
        socialpratice.setStudentId(studentId);
        if(socialpratice.getUnit()==null)return Result.error("社会实践单位输入不合法");
        if(socialpratice.getStartData()==null)return Result.error("社会实践开始时间输入不合法");
        if(socialpratice.getEndData()==null)return Result.error("社会实践结束时间输入不合法");
        if(socialpratice.getStartData().compareTo(socialpratice.getEndData())>0)return Result.error("社会实践开始时间不能早于社会实践结束时间");
        if(socialpratice.getEndData().compareTo(toString(LocalDate.now()))>0) return Result.error("社会实践结束时间不应该晚于今天");
        if(socialpratice.getCertifier()==null)return Result.error("社会实践证明人输入不合法");
        if(socialpratice.getEvaluate()==null)return Result.error("社会实践评价输入不合法");
        log.info("更新社会实践信息:{}",socialpratice);
        if(!socialpraticeService.updateSocialpratice(socialpratice)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }
}