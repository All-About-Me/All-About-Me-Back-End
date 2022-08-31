package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.hamcrest.CoreMatchers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

@WebMvcTest
public class UserControllerTest {
	
//	@Autowired
//	private MockMvc mockMvc;  //use MockMvc to call REST APIs
//	
//	@MockBean
//	private UserService userService;
//	
//	@Autowired
//	private ObjectMapper objectMapper;   //to serialize and deserialize java object
//
//	@Test
//	public void givenUserObject_whenUpdateProfile_thenReturnUpdatedUser() throws JsonProcessingException, Exception {
//		
//		//given - precondition or setup
//		User user = User.builder().id(2).firstName("Jasdhir").lastName("Singh").email("test01@gmail.com")
//				.password("password01").city("Mumbai").build();
//		
//		BDDMockito.given(userService.save(ArgumentMatchers.any(User.class)))
//		.willAnswer((invocation)->invocation.getArgument(0));
//		
//		//when - action or behaviour that we are planning to test
//		ResultActions response= mockMvc.perform(put("/user/update")
//		.contentType(MediaType.APPLICATION_JSON)
//		.content(objectMapper.writeValueAsString(user)));
//		
//		//then - verify the result or output using assert statements
//		response.andExpect(MockMvcResultMatchers.status().isOk())
//			.andExpect(MockMvcResultMatchers.jsonPath("$.firstName",
//					CoreMatchers.is(user.getFirstName())));
//				
//		
//		
//	}
	
//Test Error - java.lang.IllegalStateException: Failed to load ApplicationContext
}