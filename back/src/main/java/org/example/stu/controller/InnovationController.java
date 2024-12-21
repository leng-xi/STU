package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Innovation;
import org.example.stu.service.InnovationService;
import org.example.stu.service.StudentService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result getInnovationList(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        return Result.success(innovationService.page(page, pageSize));
    }


   /* @GetMapping("/getInnovationListByStudentId")
    public Result getInnovationListByStudentId(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer studentId) {
        return Result.success(innovationService.pageByStudentId(page, pageSize, studentId));
    }*/

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
        if(!name.equals(innovation.getStudentName())){
            return Result.error("学生姓名与学号不匹配");

        }        log.info("新增学生的创业项目信息:{}",innovation);
        if(!innovationService.addInnovation(innovation)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
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