package com.study.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.customer.dao.CustManagementDao;

@Controller
public class MyController {
	
	@Autowired
	CustManagementDao dao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/")
	public String root() throws Exception{
		return "redirect:signup/signup";
	}
	
	@RequestMapping("/signup/signup")
	public String signup(Member member, Model model)
	{
		return "signup/signup";
	}
	
	@RequestMapping("/guest/welcome")
	public String welcome1(){
		return "guest/welcome1";
	}
	
	@RequestMapping("/admin/welcome")
	public String welcome3(){
		return "admin/welcome3";
	}
	
	@RequestMapping("/signup/custregi")
	public String write(HttpServletRequest request, Model model) {
		dao.CustRegiDao(request.getParameter("name")
				, passwordEncoder.encode(request.getParameter("password")));
				/*, request.getParameter("password"));*/
		
		return "loginForm";						
	}
	
}
