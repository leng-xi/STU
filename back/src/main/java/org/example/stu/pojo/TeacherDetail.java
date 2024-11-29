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
 * 教师详细信息
 * </p>
 *
 * @author 
 * @since 2024-10-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teacher_detail")
public class TeacherDetail implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 民族
     */
    private String group;

    /**
     * 籍贯
     */
    private String address;

    /**
     * 政治面貌
     */
    private String policyFace;

    /**
     * 学历
     */
    private String education;

    /**
     * 科研成果
     */
    private String scientific;


}
