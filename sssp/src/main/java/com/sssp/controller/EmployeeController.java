package com.sssp.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssp.entity.Employee;
import com.sssp.service.EmployeeService;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 22, 2015
 */
@Controller
public class EmployeeController {
	@Resource
	private EmployeeService employeeService;
	
	private final static int PAGE_SIZE = 5;
	
	@RequestMapping("/emp/empList")
	public String empList(@RequestParam(name = "pageNo", required = false, defaultValue = "1")String page, Map<String, Object> map){
		Page<Employee> emps = employeeService.empList(Integer.valueOf(page), PAGE_SIZE);
		map.put("page", emps);
		return "/emp/empList";
	}
	
}
