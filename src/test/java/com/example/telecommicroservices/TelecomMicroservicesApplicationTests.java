package com.example.telecommicroservices;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.telecommicroservices.controller.TelecomController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TelecomMicroservicesApplicationTests {

	
    @Autowired
    private TelecomController controller;
    
	@Test
	public void contextLoads() {
		  assertThat(controller).isNotNull();
	}

}

