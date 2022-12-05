package com.hj.homework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.homework.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
