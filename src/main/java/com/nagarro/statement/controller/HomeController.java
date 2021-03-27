package com.nagarro.statement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	Logger logger = LoggerFactory.getLogger(HomeController.class);
@GetMapping("/")	
 public String welcome(){
	logger.info("Requested Home page controller");
	 return "index";
 }

@GetMapping("/home")	
public String home(){
	logger.info("Requested Home page controller");
	 return "home";
}
}
