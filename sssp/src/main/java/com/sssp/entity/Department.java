package com.sssp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * desc: TODO
 * 
 * @author xuelin
 * @date Sep 22, 2015
 */
@Entity
@Table(name = "SSSP_DEPARTMENTS")
public class Department implements Serializable {
	
	private static final long serialVersionUID = -4043035200680584866L;
	
	private Integer id;
	private String deptName;
	private Date createTime;
	
	public Department() {
		super();
	}
	
	public Department(String deptName) {
		super();
		this.deptName = deptName;
		this.createTime = new Date();
	}
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "DEPT_NAME")
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + "]";
	}
	
}
