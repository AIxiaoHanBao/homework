package com.hj.homework.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 学院
 */
@Data
@Component
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private Integer id;

    /**
     * 学院名称
     */
    private String collegeName;

}
