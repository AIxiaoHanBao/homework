package com.hj.homework.pojo;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;


import java.io.Serializable;

/**
 * 成绩表
 */
@Data
@Component
public class Achievement implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 学生分数
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Double studentScore;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 学号
     */
    private Integer studentNo;

}
