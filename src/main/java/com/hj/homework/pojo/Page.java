package com.hj.homework.pojo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Page {
    private long pageNum;
    private long pageTotal;
    private long pageSize;
}
