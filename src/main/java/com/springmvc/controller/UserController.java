package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.service.MyService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	MyService service;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/sign_in")
	public String get(HttpServletRequest httpServletRequest) {
		String username = httpServletRequest.getParameter("username");
		String userpassword = httpServletRequest.getParameter("password");
		if ("".equals(username) || "".equals(userpassword)) {
			httpServletRequest.setAttribute("message", "帳號和密碼不得為空");
			return "signin";
		}
		String name = service.LoginCertification(username, userpassword);
		if (name == null) {
			httpServletRequest.setAttribute("message", "帳號或密碼錯誤");
			return "signin";
		} else {
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute("userInfo", "login");
			session.setAttribute("Username", name);
			return "redirect:/";
		}
	}

	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}

	@PostMapping("/register")
	public String userRegisterUser(HttpServletRequest httpServletRequest) {
		String username = httpServletRequest.getParameter("username");
		String userpassword = httpServletRequest.getParameter("password");
		if("".equals(username)||"".equals(userpassword)) {
			httpServletRequest.setAttribute("message", "帳號或密碼不得為空");
			return "register";
		}		
		if(!service.register(username, userpassword)) {
			httpServletRequest.setAttribute("message", "帳號重複");
			return "register";		
		}else {
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute("userInfo", "login");
			session.setAttribute("Username", username);
			return "redirect:/";
		}			
	}

	@GetMapping("/sign_in")
	public String signin() {
		return "signin";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}
