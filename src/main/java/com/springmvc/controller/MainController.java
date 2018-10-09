package com.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//WEB-INF/views/commit資料夾放置用js ajax取得的頁面
@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@GetMapping(value = "/getheader")
	public String getheader() {
		return "commit/header";
	}

	@GetMapping(value = "/")
	public String indx() {
		return "index";
	}
}
