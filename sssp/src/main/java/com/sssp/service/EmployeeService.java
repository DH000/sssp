package com.sssp.service;

import org.springframework.data.domain.Page;

import com.sssp.entity.Employee;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 22, 2015
 */
public interface EmployeeService {
	
	public Page<Employee> empList(Integer pageNo, Integer pageSize);
	
}
