package com.exercise;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GeoNamesApplication.class)
@WebAppConfiguration
public class ZipCodeControllerTests {
	protected MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testZipCodeDetailsService() throws Exception {
		this.mockMvc.perform(get("/zip/07310")).andExpect(status().isOk()).andExpect(content().json(
				"{\"placeName\":\"Jersey City\",\"stateName\":\"New Jersey\",\"stateCode\":\"NJ\",\"countyName\":\"Hudson\"}"));
	}

	@Test
	public void testStateDetailService() throws Exception {
		this.mockMvc.perform(get("/zipcounty/count/NJ")).andExpect(status().isOk()).andExpect(content().json(
				"{\"stateName\":\"New Jersey\",\"stateCode\":\"NJ\",\"numberOfCounties\":21,\"numberOfZipCodes\":723}"));
	}

	@Test
	public void testZipCodeDetailsServiceException() throws Exception {
		this.mockMvc.perform(get("/zip/xxxxx")).andExpect(status().is4xxClientError()).andExpect(content().json(
				"{\"statusCode\":\"NOT_FOUND\",\"message\":\"xxxxx not found \"}"));
	}

	@Test
	public void testStateDetailServiceException() throws Exception {
		this.mockMvc.perform(get("/zipcounty/count/XX")).andExpect(status().is4xxClientError()).andExpect(content().json(
				"{\"statusCode\":\"NOT_FOUND\",\"message\":\"XX not found\"}"));
	}
}
