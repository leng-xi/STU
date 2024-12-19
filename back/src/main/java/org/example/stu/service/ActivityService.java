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

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Activity> activityList = activityMapper.selectAll();
        Page<Activity> p = (Page<Activity>) activityList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    public PageBean processedPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Activity> activityList = activityMapper.selectProcessedAll();
        Page<Activity> p = (Page<Activity>) activityList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    public boolean addActivity(Activity activity){
        activity.setApproveStatus("未批准");
        try {
            int rowsAffected = activityMapper.insert(activity);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to add activity", e);
        }
    }

    public boolean deleteActivity(Activity activity){
        try {
            int rowsAffected = activityMapper.deleteById(activity.getId());
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to delete activity", e);
        }
    }

    public boolean updateActivity(Activity activity){
        try {
            int rowsAffected = activityMapper.updateById(activity);
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update activity", e);
        }
    }
    public boolean approveActivity(Activity activity){
        activity.setApproveStatus("批准成功");
        try {
            int rowsAffected = activityMapper.updateById(activity);
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update activity", e);
        }
    }

    public boolean rejectActivity(Activity activity){
        activity.setApproveStatus("批准失败");
        try {
            int rowsAffected = activityMapper.updateById(activity);
            return rowsAffected > 0;
        }
        catch (Exception e) {
            // 处理异常，例如记录日志、抛出运行时异常等
            // 这里简单地重新抛出异常，但在实际应用中您可能希望有更复杂的错误处理逻辑
            throw new RuntimeException("Failed to update studentleave", e);
        }
    }
}
