package com.springmvc.listerener;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.springmvc.model.Product;
import com.springmvc.model.ShopCart;
import com.springmvc.model.User;
import com.springmvc.service.MyService;

@WebListener
public class SessionListerener implements HttpSessionListener {
	private static final Logger logger = LoggerFactory.getLogger(SessionListerener.class);

	static private int activeSession;

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		activeSession++;
		System.out.println(activeSession);
		HttpSession session = arg0.getSession();
		session.setMaxInactiveInterval(10 * 60);
		User user = new User();
		session.setAttribute("User", user);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		Map<String, ShopCart> order = (Map<String, ShopCart>) session.getAttribute("order");
		User user = (User) session.getAttribute("User");
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
		MyService service = (MyService) ctx.getBean("MyService");
		if (order != null) {
			service.updataUser(user.getUsername(), order);
		}
		activeSession--;
	}
}
