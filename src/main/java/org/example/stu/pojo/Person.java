package org.example.stu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int personId;
    private String num;
    private String name;
    private int type ;
    private String dept;
    private String card;
    private int gender;
    private LocalDate birthday;
    private String email;
    private String phone;
    private String address;
}
