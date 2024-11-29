package org.example.stu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("teacher")
public class Teacher {
    private Integer id;
    private String title;
    private String degree;
    private Integer personId;
    @TableField(exist = false)
    private Person person;
    @TableField(exist = false)
    private User user;

}
