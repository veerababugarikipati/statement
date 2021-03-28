package com.nagarro.statement.service;

import com.nagarro.statement.entity.Account;
import com.nagarro.statement.entity.Statement;
import com.nagarro.statement.repository.StatementRepository;
import com.nagarro.statement.service.impl.StatementServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StatementServiceTest {


	@InjectMocks
	private StatementServiceImpl statementService;

	@Mock
	private StatementRepository statementRepository;


	@Test
	public void testGetStatement() {
		Statement statement = new Statement();
		statement.setId(1l);
		Account account = new Account();
		account.setId(1L);
		statement.setAccount(account);
		statement.setAmount("1000");
		statement.setDateField("18.01.2021");
		when(statementRepository.findByAccountId(any())).thenReturn(Arrays.asList(statement));
		List<Statement> result = statementService.getStatement(1l,null,null,null,null);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(1, result.size());
		Assertions.assertEquals(statement.getId(), result.get(0).getId());
	}

	@Test
	public void testGetStatement_When_Timeperiod_Passed() {
		Statement statement = new Statement();
		statement.setId(1l);
		Account account = new Account();
		account.setId(1L);
		statement.setAccount(account);
		statement.setAmount("1000");
		statement.setDateField("18.01.2012");
		when(statementRepository.findByAccountId(any())).thenReturn(Arrays.asList(statement));
		List<Statement> result = statementService.getStatement(1l, LocalDate.now().minusYears(10),LocalDate.now().minusYears(2),null,null);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(1, result.size());
		Assertions.assertEquals(statement.getId(), result.get(0).getId());
	}

	@Test
	public void testGetStatement_When_Amount_Passed() {
		Statement statement = new Statement();
		statement.setId(1l);
		Account account = new Account();
		account.setId(1L);
		statement.setAccount(account);
		statement.setAmount("1000");
		statement.setDateField("18.01.2012");
		when(statementRepository.findByAccountId(any())).thenReturn(Arrays.asList(statement));
		List<Statement> result = statementService.getStatement(1l, LocalDate.now().minusYears(10),LocalDate.now().minusYears(2),800.0,1200.0);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(1, result.size());
		Assertions.assertEquals(statement.getId(), result.get(0).getId());
	}

	@Test
	public void testGetStatement_When_Amount_Passed_Not_Match() {
		Statement statement = new Statement();
		statement.setId(1l);
		Account account = new Account();
		account.setId(1L);
		statement.setAccount(account);
		statement.setAmount("1300");
		statement.setDateField("18.01.2012");
		when(statementRepository.findByAccountId(any())).thenReturn(Arrays.asList(statement));
		List<Statement> result = statementService.getStatement(1l, LocalDate.now().minusYears(10),LocalDate.now().minusYears(2),800.0,1200.0);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(0, result.size());
	}




}