package org.example.stu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("person")
public class Person {
    private Integer id;
    private String name;
    private Integer type ;
    private String dept;
    private String card;
    private Integer gender;
    private LocalDate birthday;
    private String email;
    private String phone;
    private String address;
}
