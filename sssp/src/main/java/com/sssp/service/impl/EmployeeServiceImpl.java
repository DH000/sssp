package com.sssp.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sssp.entity.Employee;
import com.sssp.repository.EmployeeRepoistory;
import com.sssp.service.EmployeeService;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 22, 2015
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeRepoistory employeeRepoistory;
	
	public Page<Employee> empList(Integer pageNo, Integer pageSize) {
		Pageable pageable = new PageRequest(pageNo - 1, pageSize, new Sort(new Sort.Order(Direction.DESC, "createTime")));
		return employeeRepoistory.findAll(pageable);
	}
	
}
