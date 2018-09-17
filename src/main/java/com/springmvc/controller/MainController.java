package com.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.Product;
import com.springmvc.service.Service;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@GetMapping(value = "/getList")
	@ResponseBody
	public ArrayList<Product> home() {
		Service service = new Service();
		ArrayList<Product> productList = service.InquireAll();
		return productList;
	}
	
	@GetMapping(value = "/getInformation")
	@ResponseBody
	public ArrayList<String> getUserInfor(@RequestParam("id") int id) {
		Service service = new Service();
		ArrayList<String> productList = service.Inquireid(id);
		return productList;
	}
	
	@GetMapping(value = "/getProductInformation")
	public String getInfor(Model model) {
		model.addAttribute("str", "aa");
		return "home";
	}
}
