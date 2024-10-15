package org.example.stu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String password;
    private String username;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
    private Person person;
}
