package com.sssp.entity;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sssp.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class EntityTest {
	@Resource
	private DataSource dataSource;
	@Resource
	private DepartmentService departmentService;
	
	@Test
	public void testEntity(){
		try {
			dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSecondLevelCache(){
		departmentService.findAll();
		departmentService.findAll();
	}
	
}
