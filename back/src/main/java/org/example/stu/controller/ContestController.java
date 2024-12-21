package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Contest;
import org.example.stu.service.ContestService;
import org.example.stu.service.StudentService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/contest")
public class ContestController {

    @Autowired
    private ContestService contestService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentInnovationList")
    public Result getStudentInnovationList(@RequestParam Integer studentId) {
        return Result.success(contestService.pageStudent(studentId));
    }


    @GetMapping("/getContestList")
    public Result getContestList(@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页查询 page={},pageSize={}",page,pageSize);
        return Result.success(contestService.page(page, pageSize));
    }

    /*
    {"id": 1,
    "name": "山大杯羽毛球",
    "studentId": 1,
    "award":"一等奖",

    "organizationalUnit" : "山东大学",
    "time" :"1999-12-2"}
    * */
    //添加创新项目
    @PostMapping("/addContest")
    public Result addContest(@RequestBody Contest contest){
        if(contest.getStudentName().isEmpty()||contest.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(contest.getStudentNum().isEmpty()||contest.getStudentNum().length()>20)return Result.error("学生学号输入不合法");

        if(!contest.getStudentName().equals(studentService.getStudentNameByCard(contest.getStudentNum()))){
            return Result.error("学生学号与姓名不匹配");
        }
        if(contest.getAward().isEmpty())Result.error("竞赛奖项输入不合法");
        if(contest.getOrganizationalUnit().isEmpty())Result.error("举办单位输入不合法");
        if(contest.getTime().isEmpty())Result.error("举办时间输入不合法");
        if (contest.getName().isEmpty())Result.error("竞赛名称输入不合法");
        log.info("新增学生的竞赛信息:{}",contest);
        if(!contestService.addContest(contest)){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    @PostMapping("/deleteContest")
    public Result deleteContest(@RequestBody Contest contest){
        log.info("删除竞赛id:{}",contest);
        if(contestService.deleteContest(contest)){
            return Result.success();
        }
        return Result.error("删除失败");
    }

    @PostMapping("/updateContest")
    public Result updateContest(@RequestBody Contest contest){
        if(contest.getStudentName().isEmpty()||contest.getStudentNum().length()>10)return Result.error("学生姓名输入不合法");
        if(contest.getStudentNum().isEmpty()||contest.getStudentNum().length()>20)return Result.error("学生学号输入不合法");
        if(!contest.getStudentName().equals(studentService.getStudentNameByCard(contest.getStudentNum()))){
            return Result.error("学生学号与姓名不匹配");
        }
        if(contest.getAward().isEmpty())Result.error("竞赛奖项输入不合法");
        if(contest.getOrganizationalUnit().isEmpty())Result.error("举办单位输入不合法");
        if(contest.getTime().isEmpty())Result.error("举办时间输入不合法");
        if (contest.getName().isEmpty())Result.error("竞赛名称输入不合法");
        log.info("新增学生的竞赛信息:{}",contest);
        if(!contestService.updateContest(contest)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }
}

