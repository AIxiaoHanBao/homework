package com.hj.homework.pojo;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 专业
 */
@Data
@Component
public class Major implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 特有表示
     */
    private Integer id;

    /**
     * 专业名称
     */
    private String majorName;

    /**
     * 专业跟的学院
     */
    private Integer majorCollegeId;

}
