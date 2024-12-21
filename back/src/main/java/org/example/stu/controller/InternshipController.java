package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Internship;
import org.example.stu.service.InternshipService;
import org.example.stu.service.StudentService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result getInternshipList(@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        return Result.success(internshipService.page(page, pageSize));
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
        if(!name.equals(internship.getStudentName())){
            return Result.error("学生姓名与学号不匹配");

        }
        log.info("新增学生的校外实习信息:{}",internship);
        if(!internshipService.addInternship(internship)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
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