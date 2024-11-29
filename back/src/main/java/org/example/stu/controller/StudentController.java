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

    /*
    查询
    例 getStudentList?page=1&pageSize=5
    page 页数
    pageSize 每页显示的条数    */
    @GetMapping("/getStudentList")
    public Result getStudentList(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize
    ){
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        PageBean pageBean = studentService.page(page, pageSize);
        return Result.success(pageBean);
    }

    /*
    新增
    传入json格式的字符串
    样例
    "major": "2",
    "className": "2",
    "person": {
        "name": "张三2",
        "type": 1,
        "dept": "1",
        "card": null,
        "gender": 1,
        "birthday": null,
        "email": null,
        "phone": null,
        "address": null
    },
    "user": {
        "password": "111",
        "username": "2322"
    }        */
    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody Student student){
        log.info("新增学生信息:{}",student);
        if(!studentService.addStudent(student)){
            return Result.error("添加失败");
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
    /*修改
    示例(与getStudentList返回值相同,去除新增和修改时间)
    "id": 1,
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
    }*/
    @PostMapping("/updateStudent")
    public Result updateStudent(@RequestBody Student student){
        log.info("更新学生信息:{}",student);
        if(!studentService.updateStudent(student)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }

}
