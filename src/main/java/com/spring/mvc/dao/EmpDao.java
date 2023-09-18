package com.spring.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mvc.entity.Emp;

@Repository
public interface EmpDao {

	public int saveEmp(Emp emp);

	public Emp getEmpById(int id);

	public List<Emp> getAllEmp();

	public void update(Emp emp);

	public void deleteEmp(int id);

}