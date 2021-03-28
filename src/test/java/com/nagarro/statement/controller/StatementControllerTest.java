package com.nagarro.statement.controller;

import com.nagarro.statement.entity.Statement;
import com.nagarro.statement.service.StatementService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class StatementControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private StatementController statementController;

	@Mock
	private StatementService statementService;


	@Test
	public void testGetStatement()
			throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/view/");
		viewResolver.setSuffix(".jsp");
		mockMvc = MockMvcBuilders.standaloneSetup(statementController).setViewResolvers(viewResolver).build();
		when(statementService.getStatement(any(),any(),any(),any(),any())).thenReturn(Arrays.asList(new Statement()));
		mockMvc.perform(MockMvcRequestBuilders.get("/statement").param("accountId","123")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}