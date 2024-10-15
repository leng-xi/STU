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

    /*page 页数
    pageSize 每页显示的条数    */
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
        log.info("添加学生信息:{}",student);
        studentService.addStudent(student);

    return Result.success();
    }

    /*通过personId删除学生*/
    @PostMapping("/deleteStudent")
    public Result deleteStudent(@RequestBody Person person){
        int personId = person.getPersonId();
        log.info("删除人员id:{}",personId);
        if(studentService.deletePerson(personId)){
            return Result.success();
        }
        return Result.error("删除失败");
    }
}
