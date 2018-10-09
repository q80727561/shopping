package com.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.Product;
import com.springmvc.model.ShopCart;

//WEB-INF/views/commit資料夾放置用js ajax取得的頁面
@Controller
public class ShoppingCartController {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

	@PostMapping(value = "/cart")
	public String addProduct(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		Map<String, ShopCart> order = (Map<String, ShopCart>) session.getAttribute("order");
		String id = httpServletRequest.getParameter("id");
		if (order != null) {
			if (order.get(id) != null) {
				int num = order.get(id).getProductnum() + 1;
				order.get(id).setProductnum(num);
				int pricetotal = (int) session.getAttribute("pricetotal");
				pricetotal = pricetotal + order.get(id).getProductprice();
				session.setAttribute("pricetotal", pricetotal);
				return "redirect:/cart";
			}
		}
		String productname = httpServletRequest.getParameter("productname");
		String img = id.substring(0, 3) + "/" + id.substring(3, 6) + "/" + id + ".jpg";
		int productprice = Integer.parseInt(httpServletRequest.getParameter("productprice"));
		ShopCart shopcart = new ShopCart();
		shopcart.setProductname(productname);
		shopcart.setProductno(id);
		shopcart.setProductnum(1);
		shopcart.setProductimg(img);
		shopcart.setProductprice(productprice);
		if (order == null) {
			order = new HashMap<String, ShopCart>();
			order.put(id, shopcart);
			session.setAttribute("order", order);
			session.setAttribute("pricetotal", productprice);
		} else {
			order.put(id, shopcart);
			int pricetotal = (int) session.getAttribute("pricetotal");
			pricetotal = pricetotal + productprice;
			session.setAttribute("pricetotal", pricetotal);
		}
		return "redirect:/cart";
	}

	@DeleteMapping(value = "/cart")
	@ResponseBody
	public String DeleteCart(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession(false);
		String id = httpServletRequest.getParameter("id");
		Map<String, ShopCart> order = (Map<String, ShopCart>) session.getAttribute("order");
		ShopCart cart = order.get(id);
		int pricetotal = (int) session.getAttribute("pricetotal");
		pricetotal = pricetotal - cart.getProductnum() * cart.getProductprice();
		session.setAttribute("pricetotal", pricetotal);
		order.remove(id);
		return "success";
	}

	@GetMapping(value = "/cart")
	public String ShoppingCart(HttpServletRequest httpServletRequest) {
		return "shoppingcart";
	}
}
