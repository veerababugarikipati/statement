package com.nagarro.statement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nagarro.statement.service.AccountService;
@Controller
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
    private AccountService accountService;
	@GetMapping("/user")	
	public String user(Model model){
		logger.info("Requested User page controller");
		 model.addAttribute("accountsIds", accountService.getAccountIds());
		 return "user";
	}
}
