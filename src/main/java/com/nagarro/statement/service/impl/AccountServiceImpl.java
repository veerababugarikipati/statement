package com.nagarro.statement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.statement.entity.Account;
import com.nagarro.statement.repository.AccountRepository;
import com.nagarro.statement.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {
	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
	private AccountRepository accountRepository;

    @Override
	public List<Long> getAccountIds() {
		return accountRepository.findAll().stream().map(Account::getId).collect(Collectors.toList());
	}
	
}
