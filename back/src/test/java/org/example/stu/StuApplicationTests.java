package org.example.stu;


import org.example.stu.mapper.LoginMapper;
import org.example.stu.mapper.PersonMapper;
import org.example.stu.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StuApplicationTests {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private PersonMapper personMapper;


    @Test
    public void test() {




    }
}
