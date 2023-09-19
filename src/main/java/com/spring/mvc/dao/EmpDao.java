package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.entity.Emp;

public interface EmpDao {
	public Long saveEmp(Emp emp);
	
	public Emp getEmpById(Long id);
	
	public List<Emp> getAllEmp();
	
	public void update(Emp emp);
	
	public void deleteEmp(Long id);
}
