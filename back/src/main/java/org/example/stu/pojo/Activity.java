package org.example.stu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("activity")
public class Activity {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer studentId;

    private Integer teacherId;

    private String name;

    private String activityType;

    private String startData;

    private String endData;

    private String organizationalUnit;

    private String approveStatus;

    private String teacherName;

    private String teacherNum;

    private String studentName;

    private String studentNum;
}
