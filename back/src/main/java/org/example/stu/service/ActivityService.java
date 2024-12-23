package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.example.stu.mapper.StudentMapper;
import org.example.stu.mapper.ActivityMapper;
import org.example.stu.mapper.TeacherMapper;
import org.example.stu.pojo.Activity;
import org.example.stu.pojo.Studentleave;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    public List<Activity> getList() {
        List<Activity> activityList = activityMapper.getList();
        for (Activity activity : activityList) {
            activity.setName(activityMapper.selectByNum(activity.getNum()).get(0).getName());
            activity.setActivityType(activityMapper.selectByNum(activity.getNum()).get(0).getActivityType());
            activity.setOrganizationalUnit(activityMapper.selectByNum(activity.getNum()).get(0).getOrganizationalUnit());
        }
        return activityList;
    }

    public PageBean page(Integer page, Integer pageSize, String select) {
        PageHelper.startPage(page, pageSize);
        List<Activity> activityList = new ArrayList<>();
        if (select.equals("1")) {
            activityList = activityMapper.selectList1("");
        } else if (select.equals("2")) {
            activityList = activityMapper.selectList("已批准");
        } else if (select.equals("3")) {
            activityList = activityMapper.selectList("未批准");
        } else if (select.equals("4")) {
            activityList = activityMapper.selectList("待审批");
        }
        Page<Activity> p = (Page<Activity>) activityList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    public PageBean processedPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Activity> activityList = activityMapper.selectProcessedAll();
        Page<Activity> p = (Page<Activity>) activityList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    public boolean addActivity(Activity activity) {
        activity.setApproveStatus("未批准");
        try {
            int rowsAffected = activityMapper.insert(activity);
            return rowsAffected > 0;
        } catch (Exception e) {
            throw new RuntimeException("Failed to add activity", e);
        }
    }

    public boolean deleteActivity(Activity activity) {
        try {
            int rowsAffected = activityMapper.deleteById(activity.getId());
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to delete activity", e);
        }
    }

    public boolean updateActivity(Activity activity) {
        try {
            int rowsAffected = activityMapper.updateById(activity);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update activity", e);
        }
    }

    public boolean approveActivity(Activity activity) {
        activity.setApproveStatus("已批准");
        try {
            int rowsAffected = activityMapper.updateById(activity);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update activity", e);
        }
    }

    public boolean rejectActivity(Activity activity) {
        activity.setApproveStatus("未批准");
        try {
            int rowsAffected = activityMapper.updateById(activity);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update studentleave", e);
        }
    }

    public boolean add(Activity activity) {
        if (!activityMapper.selectByNum(activity.getNum()).isEmpty()) return false;
        activityMapper.insert(activity);
        return true;
    }

    public boolean add(Integer studentId, String activityNum) {
        if(activityMapper.selectByNumAndStudentId(studentId, activityNum)!=null)return false;
        Activity activity =new Activity();
        activity.setStudentId(studentId);
        activity.setNum(activityNum);
        activity.setApproveStatus("未批准");
        List<Activity> temp=activityMapper.selectByNum(activityNum);
        activity.setName(temp.get(0).getName());
        activity.setOrganizationalUnit(temp.get(0).getOrganizationalUnit());
        activity.setActivityType(temp.get(0).getActivityType());
        activityMapper.insert(activity);
        return true;
    }
}
