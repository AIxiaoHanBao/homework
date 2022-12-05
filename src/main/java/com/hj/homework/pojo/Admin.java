package com.hj.homework.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 用户登录
 */
@Data
@Component
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名账号
     */
    private String userAccount;
    /**
     * 用户名
     */
    private String userPassword;

}
