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
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") String input,
                                 @RequestParam(defaultValue = "") String select
                                 ) {
        log.info("分页查询 page={},pageSize={},input={},select={}", page, pageSize,input,select);
        PageBean pageBean = studentService.page(page, pageSize,input,select);
        return Result.success(pageBean);
    }
    @GetMapping("/getList")
    public Result getList(@RequestParam Integer id) {
        log.info("id:{}", id);
        return Result.success(studentService.getList(id));
    }
    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody Student student) {
        log.info("新增学生信息:{}", student);
        if (student.getPerson().getName().isEmpty() || student.getPerson().getName().length() > 10)
            return Result.error("姓名输入不合法");
        if (student.getPerson().getUsername().isEmpty() || student.getPerson().getUsername().length() > 20)
            return Result.error("学号输入不合法");
        //if(student.getPerson().getCard().isEmpty()||student.getPerson().getCard().length()!=18)return Result.error("身份证号输入不合法");
        if (!studentService.addStudent(student)) {
            return Result.error("该学生已存在");
        }
        return Result.success("添加成功");
    }

    /*通过personId删除学生
    "id":1
    */
    @PostMapping("/deleteStudent")
    public Result deleteStudent(@RequestBody Person person) {
        int personId = person.getId();
        log.info("删除人员id:{}", personId);
        if (studentService.deletePerson(personId)) {
            return Result.success();
        }
        return Result.error("删除失败");
    }
    @GetMapping("/password")
    public Result password(@RequestParam(defaultValue = "") String personId,
                           @RequestParam(defaultValue = "") String old,
                           @RequestParam(defaultValue = "") String newp) {
        if (studentService.password(personId,old, newp)) {
            return Result.success("修改成功");
        }
        return Result.error("密码错误");
    }

    @PostMapping("/updateStudent")
    public Result updateStudent(@RequestBody Student student) {
        log.info("更新学生信息:{}", student);
        if (student.getPerson().getName().isEmpty() || student.getPerson().getName().length() > 10)
            return Result.error("姓名输入不合法");
        if (student.getPerson().getUsername().isEmpty() || student.getPerson().getUsername().length() > 20)
            return Result.error("学号输入不合法");
        if (!studentService.updateStudent(student)) {
            return Result.error("学号已存在");
        }
        return Result.success("更新成功");
    }
}
