package org.example.stu.exception;

import org.example.stu.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理异常
    @ExceptionHandler(Exception.class) //指定能够处理的异常类型
    public Result ex(Exception e){
        e.printStackTrace();//打印堆栈中的异常信息
        return Result.error("哔咔哔咔被玩坏了,这肯定不是哔咔的问题,绝对不是!");
    }
}