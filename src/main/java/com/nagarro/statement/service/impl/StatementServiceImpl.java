package com.nagarro.statement.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.statement.entity.Statement;
import com.nagarro.statement.repository.StatementRepository;
import com.nagarro.statement.service.StatementService;

@Service
public class StatementServiceImpl implements StatementService {
	Logger logger = LoggerFactory.getLogger(StatementServiceImpl.class);
    @Autowired
    private StatementRepository statementRepository;

    @Override
    public List<Statement> getStatement(Long accountId, LocalDate fromDate, LocalDate toDate, Double fromAmount, Double toAmount) {
        return statementRepository.findByAccountId(accountId).stream()
                .filter(statement -> isValidMonthRange(statement.getDateField(), fromDate, toDate) && isValidAmountRange(statement.getAmount(),fromAmount,toAmount))
                
                .collect(Collectors.toList());
    }

    public boolean isValidMonthRange(String date, LocalDate from, LocalDate to) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);

        if (null == from && null == to) {
            return ChronoUnit.MONTHS.between(localDate, LocalDate.now()) <= 2;
        } else {
            return localDate.isAfter(from) && localDate.isBefore(to);
        }
    }

	public boolean isValidAmountRange(String amount, Double from, Double to) {
		Double amt = Double.parseDouble(amount);
		if (null == from && null == to) {
			return true;
		} else {
			return (amt >= from && amt <= to);
		}
	}

}
