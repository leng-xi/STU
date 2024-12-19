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
@TableName("contest")
public class Contest {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer studentId;

    private String name;

    private String award;

    private String time;

    private String organizationalUnit;

    private String studentName;

    private String studentNum;
}

