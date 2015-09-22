package com.sssp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sssp.entity.Employee;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 22, 2015
 */
public interface EmployeeRepoistory extends JpaRepository<Employee, Integer> {
	
}
