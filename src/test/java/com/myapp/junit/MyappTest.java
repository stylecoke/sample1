package com.myapp.junit;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

// 테스트할 DI 컨테이너를 웹 애플리케이션 전용 DI 컨테이너로 처리
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		                         "file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class MyappTest {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mock;
    
	@Before
	public void setup() {
		 mock = MockMvcBuilders.webAppContextSetup(this.ctx).build();
	}
	
	
	@Test
	public void homeViewTest() throws Exception {
		
		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/");

		mock.perform(reqBuilder)
			.andExpect(status().isOk())
			.andExpect(view().name("home"));
	}
	
	@Test
	public void listViewTest() throws Exception {

		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/list");

		mock.perform(reqBuilder)
			.andExpect(status().isOk())
			.andExpect(view().name("list"))
			.andExpect(model().attributeExists("boardList"));

	}
	
	@Test
	public void readViewTest() throws Exception {

		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/read/12");
		
		mock.perform(reqBuilder)
			.andExpect(status().isOk())
			.andExpect(view().name("read"))
			.andExpect(model().attributeExists("boardVO"));
	}
	
	@Test
	public void writeViewGetTest() throws Exception {

		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/write");
		
		mock.perform(reqBuilder)
			.andExpect(status().isOk())
			.andExpect(view().name("write"))
			.andExpect(model().attributeExists("boardVO"));
	}

	
	@Test
	@Transactional
	public void writeViewPostTest() throws Exception {
		
		RequestBuilder reqBuilder = MockMvcRequestBuilders
								    .post("/write")
									.param("title", "title")
		  							.param("content", "content")
		  	                        .param("writer", "writer")
		                            .param("password", "1234");
		
		mock.perform(reqBuilder)
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/list"));
	}
	
}
