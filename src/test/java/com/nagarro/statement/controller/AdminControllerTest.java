package com.nagarro.statement.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.nagarro.statement.service.AccountService;

@SpringBootTest
public class AdminControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private AdminController adminController;

	@Mock
	private AccountService accountService;


	@Test
	public void testAdmin()
			throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/view/");
		viewResolver.setSuffix(".jsp");
		mockMvc = MockMvcBuilders.standaloneSetup(adminController).setViewResolvers(viewResolver).build();
		when(accountService.getAccountIds()).thenReturn(Arrays.asList(1L));
		mockMvc.perform(MockMvcRequestBuilders.get("/admin")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}