package com.study.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.account.dao.IAccountDao;
import com.study.springboot.customer.dao.ICustManagementDao;

@Controller
public class MyController {
	
	@Autowired
	ICustManagementDao dao;

	@Autowired
	IAccountDao accountDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/")
	public String root() throws Exception{
		//return "redirect:signup/signup";
		return "security/loginForm";
		
	}
	@RequestMapping("/loginForm")
	public String loginForm() throws Exception{
		//return "redirect:signup/signup";
		return "security/loginForm";
		
	}
	
	@RequestMapping("/signup/signup")
	public String signup(Member member, Model model){
		return "signup/signup";
	}
	
	@RequestMapping("/guest/welcome")
	public String welcome1(Model model) {
		
		return "guest/welcome1";
	}
	
	@RequestMapping("/member/welcome")
	public String welcome2(HttpServletRequest request, Model model) {
		
		System.out.println("=========================================================");
		//String name = request.getParameter("j_username");
		String name = "김동혁2";
		System.out.println("============================name2222============================="+name);
		model.addAttribute("list", accountDao.accountListDao(name));
		return "member/welcome2";
	}
	
	@RequestMapping("/member/send")
	public String send(HttpServletRequest request, Model model){
		int amount = Integer.parseInt(request.getParameter("amount"));
		int balance = Integer.parseInt(request.getParameter("balance"));
		balance = balance - amount;
		accountDao.sendDao(request.getParameter("myAccount"), balance);
		accountDao.receiveDao(request.getParameter("accountToSend"), amount);
		return "member/sendSuccess";
	}
	
	@RequestMapping("/admin/welcome")
	public String welcome3(){
		return "admin/welcome3";
	}
	

	
	@RequestMapping("/signup/custregi")
	public String write(HttpServletRequest request, Model model) {
		
		String authority = "ROLE_USER";
		if(null != request.getParameter("authority")) {
			authority = request.getParameter("authority");
		}
		
		
		dao.custRegiDao(request.getParameter("name")
				, passwordEncoder.encode(request.getParameter("password"))
				, authority);
						
		return "security/loginForm";						
	}
	
}
