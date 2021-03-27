package com.nagarro.statement.service;

import java.time.LocalDate;
import java.util.List;

import com.nagarro.statement.entity.Statement;
public interface StatementService {
	List<Statement> getStatement(Long accountId, LocalDate fromDate,LocalDate toDate, Double fromAmount, Double toAmount);
}
