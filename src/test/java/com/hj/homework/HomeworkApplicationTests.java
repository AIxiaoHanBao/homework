package com.hj.homework;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hj.homework.mapper.AdminMapper;
import com.hj.homework.pojo.Admin;
import com.hj.homework.service.AdminServie;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class HomeworkApplicationTests {

	@Autowired
	private AdminServie adminServie;
	@Autowired
	private AdminMapper adminMapper;

	@Test
	void contextLoads() {
		Page<Admin> page = Page.of(1,5);
		QueryWrapper<Admin> wrapper = new QueryWrapper<>();
		wrapper.select("*");
		Page<Admin> adminPage = adminMapper.selectPage(page, wrapper);
		for (Admin record : adminPage.getRecords()) {
			System.out.println(record.toString());
		}

		System.out.println(	adminPage.getTotal());
	}

}
