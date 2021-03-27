package com.nagarro.statement.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.statement.service.StatementService;

@Controller

public class StatementController {
	Logger logger = LoggerFactory.getLogger(StatementController.class);
    @Autowired
    private StatementService statementService;
    
    @GetMapping("/statement")
    public String getStatement(@RequestParam (value = "accountId") Long accountId,
                               @RequestParam(value = "fromDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fromDate,
                               @RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate toDate,
                               @RequestParam(value = "fromAmount",required = false) Double fromAmount,
                               @RequestParam(value = "toAmount",required = false) Double toAmount
                                ,Model model) {
    	logger.info("Requested Statement controller@@@"+accountId+"@@@fromDate@@@"+fromDate+"@@@todate@@@"+toDate+"@@@fromAmount@@@"+fromAmount+"@@@toAmount@@@"+toAmount);
        model.addAttribute("statement", statementService.getStatement(accountId,fromDate,toDate,fromAmount,toAmount));
        return "statement";
    }
 
}
