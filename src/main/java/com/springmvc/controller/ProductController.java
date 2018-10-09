package com.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.model.Product;
import com.springmvc.service.MyService;

@Controller
public class ProductController {	
	@Autowired
	MyService service;
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@GetMapping("/category-list")
	public String categoryList() {
		return "main";
	}
	//{listType} tw en 目前先設定/tw /en 
	@GetMapping({"/category-list/{listType}","/{listType}","/product/{id}"})
	public String list() {
		return "listpage";
	}
	@PostMapping({"/category-list/{listType}","/{listType}"})
	public String getlist(@PathVariable("listType") String listType,HttpServletRequest httpServletRequest) {
		ArrayList<Product> productList;
		productList = service.InquireType(listType);
		httpServletRequest.setAttribute("personList", productList);
		return "commit/list";
	}
	@PostMapping("/product/{id}")
	public String getProductInfo(@PathVariable("id") String id,HttpServletRequest httpServletRequest) {
		ArrayList<String> productInfo;
		productInfo = service.Inquireid(id);
		productInfo.add(id);
		httpServletRequest.setAttribute("productInfo", productInfo);
		return "commit/productInfo";
	}
}
