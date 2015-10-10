package com.sssp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sssp.entity.Department;
import com.sssp.repository.DepartmentRepository;
import com.sssp.service.DepartmentService;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 23, 2015
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Resource
	private DepartmentRepository departmentRepository;
	
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}
	
}
