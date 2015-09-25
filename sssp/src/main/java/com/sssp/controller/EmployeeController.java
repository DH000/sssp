package com.sssp.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sssp.entity.Department;
import com.sssp.entity.Employee;
import com.sssp.service.DepartmentService;
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
	@Resource
	private DepartmentService departmentService;
	
	private final static int PAGE_SIZE = 5;
	
	@ModelAttribute
	public void getEmployee(@RequestParam(name = "id", required = false) Integer id, Map<String, Object> map){
		if(null != id){
			Employee employee = employeeService.findById(id);
			// 修改部门
			employee.setDepartment(null);
			map.put("employee", employee);
		}
	}
	
	@RequestMapping("/emp/empList")
	public String empList(@RequestParam(name = "pageNo", required = false, defaultValue = "1")String page, Map<String, Object> map){
		Page<Employee> emps = employeeService.empList(Integer.valueOf(page), PAGE_SIZE);
		map.put("page", emps);
		return "/emp/empList";
	}
	
	@ResponseBody
	@RequestMapping("/emp/empNameIsExist")
	public String nameIsExist(@RequestParam(name = "name", required = true)String name){
		Employee employee = employeeService.findByName(name);
		if(null != employee){
			return "1";
		}
		
		return "0";
	}
	
	@RequestMapping(value = "/emp/add", method = RequestMethod.GET)
	public String toAddEmp(Map<String, Object> map){
		List<Department> departments = departmentService.findAll();
		map.put("departments", departments);
		map.put("employee", new Employee());
		return "/emp/add";
	}
	
	@RequestMapping(value = "/emp/add", method = RequestMethod.POST)
	public String addEmp(Employee employee){
		employee.setCreateTime(new Date());
		employeeService.save(employee);
		return "redirect:/emp/empList";
	}
	
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Map<String, Object> map){
		Employee employee = employeeService.findById(id);
		List<Department> departments = departmentService.findAll();
		map.put("departments", departments);
		map.put("employee", employee);
		return "/emp/add";
	}
	
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
	public String update(Employee employee){
		employeeService.update(employee);
		return "redirect:/emp/empList";
	}
	
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id")  Integer id){
		employeeService.delete(id);
		return "redirect:/emp/empList";
	}
	
}




