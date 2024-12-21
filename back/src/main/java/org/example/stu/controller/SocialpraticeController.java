package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Socialpratice;
import org.example.stu.service.SocialpraticeService;
import org.example.stu.service.StudentService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        if(!name.equals(socialpratice.getStudentName())){
            return Result.error("学生姓名与学号不匹配");

        }
        log.info("新增学生的社会实践信息:{}",socialpratice);
        if(!socialpraticeService.addSocialpratice(socialpratice)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
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
        if(!name.equals(socialpratice.getStudentName())){
            return Result.error("学生姓名与学号不匹配");

        }
        log.info("更新社会实践信息:{}",socialpratice);
        if(!socialpraticeService.updateSocialpratice(socialpratice)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }
}