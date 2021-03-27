/**
 * 
 */
package com.nagarro.statement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nagarro.statement.service.AccountService;

/**
 * @author veerababu
 *
 */
@Controller
public class AdminController {
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
    private AccountService accountService;
	@GetMapping("/admin")	
	public String admin(Model model){
		logger.info("Requested Admin page controller");
		 model.addAttribute("accountsIds", accountService.getAccountIds());
		 return "admin";
	}
}
