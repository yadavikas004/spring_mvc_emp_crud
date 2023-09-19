package com.spring.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.mvc.entity.Emp;

@Service
@Repository()
public class EmpDaoImpl implements EmpDao{
	
	
	
	public EmpDaoImpl() {	
	}

	public EmpDaoImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public Long saveEmp(Emp emp) {
		// TODO Auto-generated method stub
		Long i = (Long) hibernateTemplate.save(emp);
		return i;
	}

	
	public Emp getEmpById(Long id) {
		// TODO Auto-generated method stub
		Emp emp = hibernateTemplate.get(Emp.class, id);
		return emp;
	}

	
	public List<Emp> getAllEmp() {
		// TODO Auto-generated method stub
		List<Emp> list = hibernateTemplate.loadAll(Emp.class);
		return list;
	}

	@Transactional
	public void update(Emp emp) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(emp);
		
	}

	@Transactional
	public void deleteEmp(Long id) {
		// TODO Auto-generated method stub
		Emp emp = hibernateTemplate.get(Emp.class, id);
		hibernateTemplate.delete(emp);
	}

}
