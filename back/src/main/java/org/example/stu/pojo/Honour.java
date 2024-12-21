
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
 * 个人荣誉
 * </p>
 *
 * @author leng-xi
 * @since 2024-10-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("honour")
public class Honour  {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生id
     */
    private Integer studentId;

    private String studentName;

    private String studentNum;

    private String name;

    private String honorLevel;

    private String time;

}