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
@RequestMapping("/category-list")
public class ProductController {	
	@Autowired
	MyService service;

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@GetMapping
	public String categoryList() {
		return "main";
	}
	@GetMapping("/{listType}")
	public String list() {
		return "listpage";
	}
	@PostMapping("/{listType}")
	public String getlist(@PathVariable String listType,HttpServletRequest httpServletRequest) {
		ArrayList<Product> productList;
		productList = service.InquireType(listType);
		httpServletRequest.setAttribute("personList", productList);
		return "list";
	}
}
