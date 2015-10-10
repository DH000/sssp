package com.sssp.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.sssp.entity.Department;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 23, 2015
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	/**
	 * 
	 * desc: 使用二级缓存	
	 * @return
	 */
	@QueryHints({@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")})
	@Query("from Department")
	public List<Department> findAll();
	
}
