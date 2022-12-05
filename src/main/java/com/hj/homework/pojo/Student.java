package com.hj.homework.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 学生表
 */
@Data
@Component
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 学号
     */
    private String studentNo;

    /**
     * 学生名称
     */
    private String studentName;

    /**
     * 学生性别
     */
    private Integer studentSex;

    /**
     * 开始学年
     */
    private String studentStartYear;

    /**
     * 结束学年
     */
    private String studentEndYear;

    /**
     * 民族
     */
    private String studentNation;

    /**
     * 学院
     */
    private String studentCollege;

    /**
     * 专业
     */
    private String studentMajor;

    /**
     * 专升本/本科/研究生
     */
    private String studentType;

}
