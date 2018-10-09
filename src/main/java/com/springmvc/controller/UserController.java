package com.springmvc.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.model.Product;
import com.springmvc.model.ShopCart;
import com.springmvc.model.User;
import com.springmvc.service.MyService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	MyService service;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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

	@PostMapping("/sign_in")
	public String get(HttpServletRequest httpServletRequest) {
		String username = httpServletRequest.getParameter("username");
		String userpassword = httpServletRequest.getParameter("password");
		if ("".equals(username) || "".equals(userpassword)) {
			httpServletRequest.setAttribute("message", "帳號和密碼不得為空");
			return "signin";
		}
		User user = service.LoginCertification(username, userpassword);

		if (user.getUsername() == null) {
			httpServletRequest.setAttribute("message", "帳號或密碼錯誤");
			return "signin";
		} else {
			HttpSession session = httpServletRequest.getSession();
			Map<String, ShopCart> sessionorder = (Map<String, ShopCart>) session.getAttribute("order");
			Map<String, ShopCart> order = service.Inquireshopcart(user.getUsername());
			int pricetotal = 0;
			if (order.size() > 0) {
				for (Entry<String, ShopCart> entry : order.entrySet()) {
					if (sessionorder!=null) {
						if (sessionorder.get(entry.getKey()) == null) {
							sessionorder.put(entry.getKey(), entry.getValue());
						} else {
							int num = entry.getValue().getProductnum() + 1;
							sessionorder.get(entry.getKey()).setProductnum(num);
						}
					}
					pricetotal = pricetotal + entry.getValue().getProductprice()*entry.getValue().getProductnum();
				}
			}
			if (sessionorder!=null) {
				int sessionpricetotal = (int) session.getAttribute("pricetotal");
				pricetotal = pricetotal + sessionpricetotal;
			} else {
				session.setAttribute("order", order);
			}
			session.setAttribute("pricetotal", pricetotal);
			session.setAttribute("User", user);
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
		if ("".equals(username) || "".equals(userpassword)) {
			httpServletRequest.setAttribute("message", "帳號或密碼不得為空");
			return "register";
		}
		if (!service.register(username, userpassword)) {
			httpServletRequest.setAttribute("message", "帳號重複");
			return "register";
		} else {
			HttpSession session = httpServletRequest.getSession();
			User user = (User) session.getAttribute("User");
			user.setUsername(username);
			user.setUserpassword(userpassword);
			return "redirect:/";
		}
	}
}
