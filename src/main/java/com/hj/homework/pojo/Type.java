package com.hj.homework.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 学生类型
 */
@Data
@Component
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer typeId;

    /**
     * 专升本/专科/本科/研究生
     */
    private String typeName;

}
