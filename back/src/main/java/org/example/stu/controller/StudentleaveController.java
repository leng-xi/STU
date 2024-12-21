package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Studentleave;
import org.example.stu.service.StudentService;
import org.example.stu.service.StudentleaveService;
import org.example.stu.service.TeacherService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/studentleave")
public class StudentleaveController {

    @Autowired
    private StudentleaveService leaveService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;







    @GetMapping("/getStudentStudentleaveList")
    public Result getStudentStudentleaveList(@RequestParam Integer studentId) {
        return Result.success(leaveService.pageStudent(studentId));
    }

    @PostMapping("/addStudentStudentleave")
    public Result addStudentStudentleave(@RequestBody Studentleave leave,Integer studentId){
        leave.setStudentId(studentId);
        leave.setStudentId(studentId);
        leave.setStudentNum(studentService.getStudentNumById(studentId));
        leave.setStudentName(studentService.getStudentNameByCard(studentService.getStudentNumById(studentId)));

        if(leave.getTeacherName().isEmpty()||leave.getTeacherName().length()>10)return Result.error("审批老师姓名输入不合法");
        if(leave.getTeacherNum().isEmpty()||leave.getTeacherNum().length()>20)return Result.error("审批老师工号输入不合法");
        if(!leave.getTeacherName().equals(teacherService.getTeacherNameByCard(leave.getTeacherNum()))){
            return Result.error("老师工号与姓名不匹配");
        }
        if (leave.getStudentleaveType().isEmpty()||leave.getStudentleaveType().length()>10)return Result.error("请假类型输入不合法");
        if (leave.getStudentleaveReason().isEmpty()||leave.getStudentleaveReason().length()>100)return Result.error("请假原因输入不合法");
        if (leave.getStartData().isEmpty())return Result.error("请假开始时间输入不合法");
        if (leave.getEndData().isEmpty())return Result.error("请假结束时间输入不合法");
        if(leaveService.haveStudentleave(leave.getStudentId(),leave.getStartData(),leave.getEndData()))return Result.error("请假时间冲突");
        log.info("新增学生的请假信息:{}",leave);
        if(!leaveService.addStudentleave(leave)){
            return Result.error("申请失败");
        }
        return Result.success("申请成功");
    }



    @GetMapping("/getStudentleaveList")
    public Result getStudentleaveList(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        return Result.success(leaveService.page(page, pageSize));
    }


    @GetMapping("/getProcessedStudentleaveList")
    public Result getProcessedStudentleaveList(@RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        return Result.success(leaveService.processedPage(page, pageSize));
    }


    /*    {
              "studentId":"1" ,
              "teacherId" : "1",
              "studentleaveType" : "病假",
              "startData" : "1",
              "endData" : "1",
              "studentleaveReason":"补牙"

    //    }*/
    //添加创新项目
    @PostMapping("/addStudentleave")
    public Result addStudentleave(@RequestBody Studentleave leave){
        if(leave.getStudentName().isEmpty()||leave.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(leave.getStudentNum().isEmpty()||leave.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(studentService.getStudentNameByCard(leave.getStudentNum()).isEmpty()){
            return Result.error("找不到学号对应的学生不匹配");
        }
        if(!leave.getStudentName().equals(studentService.getStudentNameByCard(leave.getStudentNum()))){
            return Result.error("学生学号与姓名不匹配");
        }
        leave.setStudentId(studentService.getStudentIdByCard(leave.getStudentNum()));
        if(leave.getTeacherName().isEmpty()||leave.getTeacherName().length()>10)return Result.error("审批老师姓名输入不合法");
        if(leave.getTeacherNum().isEmpty()||leave.getTeacherNum().length()>20)return Result.error("审批老师工号输入不合法");
        if(!leave.getTeacherName().equals(teacherService.getTeacherNameByCard(leave.getTeacherNum()))){
            return Result.error("老师工号与姓名不匹配");
        }
        if (leave.getStudentleaveType().isEmpty()||leave.getStudentleaveType().length()>10)return Result.error("请假类型输入不合法");
        if (leave.getStudentleaveReason().isEmpty()||leave.getStudentleaveReason().length()>100)return Result.error("请假原因输入不合法");
        if (leave.getStartData().isEmpty())return Result.error("请假开始时间输入不合法");
        if (leave.getEndData().isEmpty())return Result.error("请假结束时间输入不合法");
        if(leaveService.haveStudentleave(leave.getStudentId(),leave.getStartData(),leave.getEndData()))return Result.error("请假时间冲突");
        log.info("新增学生的请假信息:{}",leave);
        if(!leaveService.addStudentleave(leave)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    @PostMapping("/deleteStudentleave")
    public Result deleteStudentleave(@RequestBody Studentleave leave){
        log.info("删除请假id:{}",leave);
        if(leaveService.deleteStudentleave(leave)){
            return Result.success();
        }
        return Result.error("删除失败");
    }
    /*   {
           "id":"2",
               "studentId":"1" ,
               "teacherId" : "1",
               "studentleaveType" : "病假",
               "startData" : "1",
               "endData" : "1",
               "studentleaveReason":"补牙"

       }*/
    @PostMapping("/updateStudentleave")
    public Result updateStudentleave(@RequestBody Studentleave leave){
        if(leave.getStudentName().isEmpty()||leave.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(leave.getStudentNum().isEmpty()||leave.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(!leave.getStudentName().equals(studentService.getStudentNameByCard(leave.getStudentNum()))){
            return Result.error("学生学号与姓名不匹配");
        }
        leave.setStudentId(studentService.getStudentIdByCard(leave.getStudentNum()));
        if(leave.getTeacherName().isEmpty()||leave.getTeacherName().length()>10)return Result.error("审批老师姓名输入不合法");
        if(leave.getTeacherNum().isEmpty()||leave.getTeacherNum().length()>20)return Result.error("审批老师工号输入不合法");
        if(!leave.getTeacherName().equals(teacherService.getTeacherNameByCard(leave.getTeacherNum()))){
            return Result.error("老师工号与姓名不匹配");
        }
        if (leave.getStudentleaveType().isEmpty()||leave.getStudentleaveType().length()>10)return Result.error("请假类型输入不合法");
        if (leave.getStudentleaveReason().isEmpty()||leave.getStudentleaveReason().length()>100)return Result.error("请假原因输入不合法");
        if (leave.getStartData().isEmpty())return Result.error("请假开始时间输入不合法");
        if (leave.getEndData().isEmpty())return Result.error("请假结束时间输入不合法");
        if(leaveService.haveStudentleave(leave.getStudentId(),leave.getStartData(),leave.getEndData()))return Result.error("请假时间冲突");
        log.info("更新竞赛信息:{}",leave);
        if(!leaveService.updateStudentleave(leave)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }
    //    {
//        "id":"2",
//            "studentId":"1" ,
//            "teacherId" : "1",
//            "studentleaveType" : "病假",
//            "startData" : "1",
//            "endData" : "1",
//            "studentleaveReason":"补牙"
//
//    }
    @PostMapping("/approveStudentleave")
    public Result approveStudentleave(@RequestBody Studentleave leave){
        log.info("更新假期批准状态:{}",leave);
        if(!leaveService.approveStudentleave(leave)){
            return Result.error("批准失败");
        }
        return Result.success("批准成功");
    }

    @PostMapping("/rejectStudentleave")
    public Result rejectStudentleave(@RequestBody Studentleave leave){
        log.info("更新假期批准状态:{}",leave);
        if(!leaveService.rejectStudentleave(leave)){
            return Result.error("批准失败");
        }
        return Result.success("批准成功");
    }
}