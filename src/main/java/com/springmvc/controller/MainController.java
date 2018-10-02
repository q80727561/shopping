package com.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.model.Product;
import com.springmvc.service.MyService;

@Controller

public class MainController {
	@Autowired
	MyService service;

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@GetMapping(value = "/getheader")
	public String getheader() {
		return "header";
	}
	
	@GetMapping(value = "/productList/get")
	public String getList(HttpServletRequest httpServletRequest) {
		String type = httpServletRequest.getParameter("type");
		String page = "";
		ArrayList<Product> productList;
		switch (type) {
		case "/":
			return "main";
		case "/category-list":
			return "main";
		case "/tw":
			productList = service.InquireType("tw");
			httpServletRequest.setAttribute("personList", productList);
			return "list";
		case "/en":
			productList = service.InquireType("en");
			httpServletRequest.setAttribute("personList", productList);
			return "list";
		case "/users/sign_in":
			return "signin";
		}
		String[] typeArray = type.split("/");
		if (typeArray.length > 2) {
			switch (typeArray[1]) {
			case "product":
				ArrayList<String> productInfo;
				productInfo = service.Inquireid(typeArray[2]);
				httpServletRequest.setAttribute("productList", productInfo);
				page = "productInfo";
				break;
			case "category-list":
				productList = service.InquireType(typeArray[2]);
				httpServletRequest.setAttribute("personList", productList);
				page = "list";
				break;
			default:
				break;
			}
		}
		return page;
	}
	@GetMapping(value = { "/","/product/{id}" })
	public String indx() {
		return "index";
	}
}
