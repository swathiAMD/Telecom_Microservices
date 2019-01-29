package com.example.telecommicroservices.controller;


import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebClient 
public class TelecomControllerTest {
	
    private Logger log = LogManager.getLogger(TelecomControllerTest.class);
	 @Autowired
	   private TelecomController cntl;
	 
	  @Autowired
	    private TestRestTemplate restTemplate;
	  
	  @Before
	    public void init() {

	        log.info("Initializing...");
	    }
	  
	@Test
	public void testGetAllPhoneNumbers() throws Exception {
		System.out.println(this.restTemplate.getForObject("http://localhost:8090/",List.class));
		assertThat(this.restTemplate.getForObject("http://localhost:8090/",
                String.class)).contains("Hello World");
		
	}

	@Test
	public void testGetSingleCustPhoneNum() {
	}

	@Test
	public void testEnablePhonenumber() {
		
	}

}
