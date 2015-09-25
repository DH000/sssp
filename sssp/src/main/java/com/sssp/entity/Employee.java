package com.sssp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * desc: TODO
 * 
 * @author xuelin
 * @date Sep 22, 2015
 */
@Entity
@Table(name = "SSSP_EMPLOYEES")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 3392197434652054400L;
	
	private Integer id;
	private String name;
	private Integer age;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private Date createTime;
	private Department department;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, Integer age, Date birthday, Department department) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.department = department;
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
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "AGE")
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY")
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID")
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + ", department=" + department + "]";
	}
	
}
