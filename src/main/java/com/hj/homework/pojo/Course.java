package com.hj.homework.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 课程表
 */
@Data
@Component
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 课程id
     */
    private Integer id;
    /**
     * 课程名称
     */
    private String courseName;

}
