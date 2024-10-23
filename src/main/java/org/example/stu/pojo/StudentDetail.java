package org.example.stu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生详细信息
 * </p>
 *
 * @author leng-xi
 * @since 2024-10-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("student_detail")
public class StudentDetail{

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 学生地址
     */
    private String address;

    /**
     * 政治面貌
     */
    private String policyFace;

    /**
     * 民族
     */
    private String group;

    /**
     * 高中
     */
    private String highSchool;

    /**
     * 初中
     */
    private String middleSchool;

    /**
     * 父亲姓名
     */
    private String father;

    /**
     * 父亲电话
     */
    private String fatherPhone;

    /**
     * 母亲姓名
     */
    private String mother;

    /**
     * 母亲电话
     */
    private String motherPhone;


}
