package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Person;
import org.example.stu.pojo.Student;
import org.example.stu.service.StudentService;
import org.example.stu.utils.PageBean;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentList")
    public Result getStudentList(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize
    ){
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        PageBean pageBean = studentService.page(page, pageSize);
        return Result.success(pageBean);
    }

    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody Student student){
        log.info("新增学生信息:{}",student);
        if(student.getPerson().getName().isEmpty()||student.getPerson().getName().length()>10)return Result.error("姓名输入不合法");
        if(student.getPerson().getUsername().isEmpty()||student.getPerson().getUsername().length()>20)return Result.error("学号输入不合法");
        //if(student.getPerson().getCard().isEmpty()||student.getPerson().getCard().length()!=18)return Result.error("身份证号输入不合法");
        if(!studentService.addStudent(student)){
            return Result.error("该学生已存在");
        }
    return Result.success("添加成功");
    }

    /*通过personId删除学生
    "id":1
    */
    @PostMapping("/deleteStudent")
    public Result deleteStudent(@RequestBody Person person){
        int personId = person.getId();
        log.info("删除人员id:{}",personId);
        if(studentService.deletePerson(personId)){
            return Result.success();
        }
        return Result.error("删除失败");
    }
    @PostMapping("/updateStudent")
    public Result updateStudent(@RequestBody Student student){
        log.info("更新学生信息:{}",student);
        if(!studentService.updateStudent(student)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }
}
