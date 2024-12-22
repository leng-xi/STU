package org.example.stu.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.Null;
import org.example.stu.pojo.Honour;
import org.example.stu.pojo.Honour;
import org.example.stu.service.HonourService;
import org.example.stu.service.StudentService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @Autowired
    private StudentService studentService;
    /*查询
    传入学生id*/



    @GetMapping("/getStudentHonourList")
    public Result getStudentHonourList(@RequestParam Integer studentId) {
        return Result.success(honourService.pageStudent(studentId));
    }


    @GetMapping("/getHonour")
    public Result getHonour(){
        log.info("查询所有荣誉信息");
        System.out.println(honourService.getAllHonours());
        return Result.success(honourService.getAllHonours());
    }

    @PostMapping("/addHonour")
    public Result addHonour(@RequestBody Honour honour){
        if(honour.getStudentName().isEmpty()||honour.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(honour.getStudentNum().isEmpty()||honour.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(!honour.getStudentName().equals(studentService.getStudentNameByCard(honour.getStudentNum()))){
            return Result.error("学生学号与姓名不匹配");
        }
        honour.setStudentId(studentService.getStudentIdByCard(honour.getStudentNum()));
        if(honour.getHonorLevel().isEmpty())return Result.error("荣誉等级不合法");

        if(honour.getTime() == null)return Result.error("获得日期不合法");
        if(honour.getTime().compareTo(toString(LocalDate.now()))>0) return Result.error("获得日期不应该晚于今天");
        if(honour.getName().isEmpty())return Result.error("荣誉名字输入不合法");
        log.info("新增学生的荣誉信息:{}",honour);
        if(!honourService.addHonour(honour)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    private String toString(LocalDate now) {
        return now.toString();
    }

    @PostMapping("/deleteHonour")
    public Result deleteHonour(@RequestBody Honour honour){
        log.info("删除荣誉:{}",honour);
        if(honourService.deleteHonour(honour)){
            return Result.success();
        }
        return Result.error("删除失败");
    }

    @PostMapping("/updateHonour")
    public Result updateHonour(@RequestBody Honour honour){
        if(honour.getStudentName().isEmpty()||honour.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(honour.getStudentNum().isEmpty()||honour.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(!honour.getStudentName().equals(studentService.getStudentNameByCard(honour.getStudentNum()))){
            return Result.error("学生学号与姓名不匹配");
        }
        honour.setStudentId(studentService.getStudentIdByCard(honour.getStudentNum()));
        if(honour.getHonorLevel().isEmpty())return Result.error("荣誉等级不合法");

        if(honour.getTime() == null)return Result.error("获得日期不合法");
        if(honour.getTime().compareTo(toString(LocalDate.now()))>0) return Result.error("获得日期不应该晚于今天");
        if(honour.getName().isEmpty())return Result.error("荣誉名字输入不合法");
        log.info("更新荣誉信息:{}",honour);
        if(!honourService.updateHonour(honour)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }


}