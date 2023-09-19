package com.spring.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		logger.info("------Session Added Deatils----------"+session);
		return "redirect:/addEmp";
	}
}
