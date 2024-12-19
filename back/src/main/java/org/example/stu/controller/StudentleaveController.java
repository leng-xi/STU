package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Studentleave;
import org.example.stu.service.StudentleaveService;
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