package com.hj.homework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.homework.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
