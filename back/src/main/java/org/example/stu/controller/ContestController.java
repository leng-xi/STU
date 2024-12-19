package org.example.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.stu.pojo.Contest;
import org.example.stu.service.ContestService;
import org.example.stu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/contest")
public class ContestController {

    @Autowired
    private ContestService contestService;

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
        log.info("更新竞赛信息:{}",contest);
        if(!contestService.updateContest(contest)){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }
}