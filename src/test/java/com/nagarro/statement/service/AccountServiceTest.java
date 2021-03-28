package com.nagarro.statement.service;

import com.nagarro.statement.entity.Account;
import com.nagarro.statement.repository.AccountRepository;
import com.nagarro.statement.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceTest {


	@InjectMocks
	private AccountServiceImpl accountService;

	@Mock
	private AccountRepository accountRepository;


	@Test
	public void testGetAccountIds() {
		Account account = new Account();
		account.setId(1l);
		when(accountRepository.findAll()).thenReturn(Arrays.asList(account));
		List<Long> result = accountService.getAccountIds();
		Assertions.assertNotNull(result);
		Assertions.assertEquals(1, result.size());
		Assertions.assertEquals(account.getId(), result.get(0));
	}




}