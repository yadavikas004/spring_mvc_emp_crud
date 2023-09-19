package com.spring.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.dao.EmpDao;
import com.spring.mvc.entity.Emp;

@Controller
public class HomeController {
	
	private static final Logger logger = LogManager.getLogger(HomeController.class);

	@Autowired
	private EmpDao empDao;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("This is Home Page");
		List<Emp> list = empDao.getAllEmp();
		model.addAttribute("empList",list);
		logger.info("----------Listed All Database Data-------------"+model.getAttribute("empList"));
		return "home";
	}
	
	@RequestMapping(value = "/addEmp", method = RequestMethod.GET)
	public String addEmp() {
		logger.info("This is Form Page");
		return "addEmp";
	}
	
	@RequestMapping(value = "/createEmp", method = RequestMethod.POST)
	public String createEmp(@ModelAttribute Emp emp, HttpSession session) {
		System.out.println(emp);
		Long i = empDao.saveEmp(emp);
		logger.info("--------------Created Employee Details-------------");
		session.setAttribute("msg", "Register Successfully");
		logger.info(emp);
		logger.info("------Session Added Deatils Successfully----------"+session.getAttribute("msg"));
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/editEmp/{id}", method = RequestMethod.GET)
	public String editEmp(@PathVariable Long id, Model model) {
		Emp emp = empDao.getEmpById(id);
		System.out.println(emp);
		model.addAttribute("emp", emp);
		return "edit-Emp";
	}
	
	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public String updateEmp(@ModelAttribute Emp emp, HttpSession session) {
		empDao.update(emp);
		logger.info("----------------Data Updated Successfully---------------------");
		logger.info(emp);
		session.setAttribute("msg","Update Successfully");
		logger.info("------Session Updated Deatils Successfully----------"+session.getAttribute("msg"));
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/deleteEmp/{id}")
	public String deleteEmp(@PathVariable Long id, HttpSession session) {
		empDao.deleteEmp(id);
		session.setAttribute("msg", "Emp Delete Successfully");
		logger.info("------Session Deleted Deatils Successfully----------"+session.getAttribute("msg"));
		return "redirect:/home";
	}
}
