package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Activity;
import org.example.stu.service.ActivityService;
import org.example.stu.service.StudentService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/getActivityList")
    public Result getActivityList(@RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        return Result.success(activityService.page(page, pageSize));
    }

    @GetMapping("/getProcessedActivityList")
    public Result getProcessedActivityList(@RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        return Result.success(activityService.processedPage(page, pageSize));
    }

    /*  {
          "studentId":"1" ,
              "teacherId" : "1",
              "activityType" : "体育赛事",
              "startData" : "1",
              "endData" : "1",
              "name":"羽毛球山大杯",
              "organizationalUnit":"软件园石宇奇"
      }*/
    //添加创新项目
    @PostMapping("/addActivity")
    public Result addActivity(@RequestBody Activity activity){
        if(activity.getStudentName().isEmpty()||activity.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(activity.getStudentNum().isEmpty()||activity.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(!activity.getStudentName().equals(studentService.getStudentNameByCard(activity.getStudentNum()))){
            return Result.error("学生学号与姓名不匹配");
        }
        activity.setStudentId(studentService.getStudentIdByCard(activity.getStudentNum()));
        if(activity.getTeacherName().isEmpty()||activity.getTeacherName().length()>10)return Result.error("审批老师姓名输入不合法");
        if(activity.getTeacherNum().isEmpty()||activity.getTeacherNum().length()>20)return Result.error("审批老师工号输入不合法");
        if(activity.getActivityType().isEmpty()||activity.getActivityType().length()>20)return Result.error("活动类型输入不合法");
        if (activity.getStartData().isEmpty())return Result.error("活动开始时间输入不合法");
        if (activity.getEndData().isEmpty())return Result.error("活动结束时间输入不合法");
        if (activity.getName().isEmpty())return Result.error("活动名称输入不合法");
        if (activity.getOrganizationalUnit().isEmpty())return Result.error("活动组织单位输入不合法");
        log.info("新增学生申请的活动信息:{}",activity);
        if(!activityService.addActivity(activity)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    @PostMapping("/deleteActivity")
    public Result deleteActivity(@RequestBody Activity activity){
        log.info("删除活动id:{}",activity);
        if(activityService.deleteActivity(activity)){
            return Result.success();
        }
        return Result.error("删除失败");
    }

    @PostMapping("/updateActivity")
    public Result updateActivity(@RequestBody Activity activity){
        if(activity.getStudentName().isEmpty()||activity.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(activity.getStudentNum().isEmpty()||activity.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(activity.getTeacherName().isEmpty()||activity.getTeacherName().length()>10)return Result.error("审批老师姓名输入不合法");
        if(activity.getTeacherNum().isEmpty()||activity.getTeacherNum().length()>20)return Result.error("审批老师工号输入不合法");
        if(activity.getActivityType().isEmpty()||activity.getActivityType().length()>20)return Result.error("活动类型输入不合法");
        if (activity.getStartData().isEmpty())return Result.error("活动开始时间输入不合法");
        if (activity.getEndData().isEmpty())return Result.error("活动结束时间输入不合法");
        if (activity.getName().isEmpty())return Result.error("活动名称输入不合法");
        if (activity.getOrganizationalUnit().isEmpty())return Result.error("活动组织单位输入不合法");
        log.info("更新活动信息:{}",activity);
        if(!activityService.updateActivity(activity)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }

    @PostMapping("/approveActivity")
    public Result approveActivity(@RequestBody Activity activity){
        log.info("更新活动批准状态:{}",activity);
        activity.setApproveStatus("已批准");
        if(!activityService.approveActivity(activity)){
            return Result.error("批准失败");
        }
        return Result.success("批准成功");
    }

    @PostMapping("/rejectActivity")
    public Result rejectActivity(@RequestBody Activity activity){
        if(activity.getStudentName().isEmpty()||activity.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(activity.getStudentNum().isEmpty()||activity.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(!activity.getStudentName().equals(studentService.getStudentNameByCard(activity.getStudentNum()))){
            return Result.error("学生学号与姓名不匹配");
        }
        activity.setStudentId(studentService.getStudentIdByCard(activity.getStudentNum()));
        if(activity.getTeacherName().isEmpty()||activity.getTeacherName().length()>10)return Result.error("审批老师姓名输入不合法");
        if(activity.getTeacherNum().isEmpty()||activity.getTeacherNum().length()>20)return Result.error("审批老师工号输入不合法");
        if(activity.getActivityType().isEmpty()||activity.getActivityType().length()>20)return Result.error("活动类型输入不合法");
        if (activity.getStartData().isEmpty())return Result.error("活动开始时间输入不合法");
        if (activity.getEndData().isEmpty())return Result.error("活动结束时间输入不合法");
        if (activity.getName().isEmpty())return Result.error("活动名称输入不合法");
        if (activity.getOrganizationalUnit().isEmpty())return Result.error("活动组织单位输入不合法");
        log.info("更新活动批准状态:{}",activity);
        if(!activityService.rejectActivity(activity)){
            return Result.error("批准失败");
        }
        return Result.success("批准成功");
    }

}



