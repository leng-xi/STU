package org.example.stu.pojo.vo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.stu.pojo.Person;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("student")
public class StudentVo {
    private Integer id;
    private String major;
    private String className;
    private Integer personId;
    private Person person;
}
