package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Person;
import org.example.stu.pojo.Teacher;
import org.example.stu.service.TeacherService;
import org.example.stu.utils.PageBean;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /*
    查询
    page 页数
    pageSize 每页显示的条数    */
    @GetMapping("/getTeacherList")
    public Result getTeacherList(@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer pageSize
    ){
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        PageBean pageBean = teacherService.page(page, pageSize);
        return Result.success(pageBean);
    }

    /*
    新增
    传入json格式的字符串
    样例
    "degree": "2",
    "title": "2",
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
    @PostMapping("/addTeacher")
    public Result addTeacher(@RequestBody Teacher teacher){
        log.info("添加教师信息:{}",teacher);
        if(!teacherService.addTeacher(teacher)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    /*通过personId删除学生*/
    @PostMapping("/deleteTeacher")
    public Result deleteTeacher(@RequestBody Person person){
        int personId = person.getId();
        log.info("删除人员id:{}",personId);
        if(teacherService.deletePerson(personId)){
            return Result.success();
        }
        return Result.error("删除失败");
    }
    /*修改
    示例(与getTeacherList返回值相同,去除新增和修改时间)
    "id": 1,
    "degree": "1",
    "title": "1",
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
    @PostMapping("/updateTeacher")
    public Result updateTeacher(@RequestBody Teacher teacher){
        log.info("更新教师信息:{}",teacher);
        if(!teacherService.updateTeacher(teacher)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }
}
