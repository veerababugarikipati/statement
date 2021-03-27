package com.nagarro.statement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	@GetMapping("/login")
	public String login(){
		logger.info("Requested  login page controller");
		return "login";
	}
}