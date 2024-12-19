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
@TableName("innovation")
public class Innovation {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

  /*  @TableField(exist = false)
    private Student student;*/

    private Integer studentId;

    private String content;

    private String project;

    private String data1;

    private String data2;

    private String tutor;

    private String studentName;

    private String studentNum;

}
