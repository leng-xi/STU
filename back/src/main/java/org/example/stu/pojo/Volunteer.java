package org.example.stu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("volunteer")
public class Volunteer {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    private Integer studentId;

    private String unit;

    private String name;

    private String evaluate;

    private String startData;

    private String endData;

    private String certifier;

    private String content;

    private String studentName;

    private String studentNum;

}
