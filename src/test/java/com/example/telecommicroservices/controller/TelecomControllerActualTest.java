package com.example.telecommicroservices.controller;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.telecommicroservices.TelecomMicroservicesApplication;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 * @author swathi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = TelecomMicroservicesApplication.class) 
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TelecomControllerActualTest {
	/**
	 * 
	 */
	static Logger loggercntrl = LogManager.getLogger(TelecomControllerActualTest.class);
	
	/**
	 * 
	 */
	 @Value("${server.port}") 
	    int port;
	 /**
	  * 
	  */
	 @Value("${spring.security.user.name}")
	 String username;
	 /**
	  * 
	  * 
	  */
	 @Value("${spring.security.user.password}")
	 String password;
	 
	 /**
	  * 
	  */
	   @Before
       public void setBaseUri () {
    	   try {

               RestAssured.port = port;
               RestAssured.baseURI = "http://localhost"; // replace as appropriate
               RestAssured.authentication=basic(username,password);
               RestAssured.registerParser("text/plain", Parser.JSON);
       }
    	   catch(Exception e) {
	              loggercntrl.debug("some error occured " ,e);
	       }
    	   
       }
	   
	   /**
	    * 
	    * @throws Exception
	    */
	   
	       @Test
	       public void testGetAllPhoneNumbers() throws Exception {
	    	   try {
	    		   Response data = get("/Phonenumbers");
	    		   loggercntrl.debug("Status code of the response testGetAllPhoneNumbers ::: " + data.getStatusCode());
	    		   
	    		   Assert.assertEquals(200, data.getStatusCode());
	    		   JSONArray jResponse = new JSONArray(data.body().asString());
	    		   loggercntrl.debug("Length Response from the REST API ::: " + jResponse.length());
	    		   loggercntrl.debug("Response from the REST API ::: " + jResponse);
	    	       Assert.assertEquals("The length has been matched", 14, jResponse.length());
	    	       JSONObject jsonobj=jResponse.getJSONObject(1);
	    	       loggercntrl.debug("Single JSON OBJ from the response of the REST API ::: " + jsonobj + "     "+jsonobj.get("phoneNumber"));
	    	       Assert.assertEquals("The length has been matched", "77777777", jsonobj.getString("phoneNumber"));
	    	      // Assert.assertNull(jResponse);
	    	       
	    	   }
	    	   catch(Exception e) {
	              loggercntrl.debug("An error was found while doing the operation::: " ,e);
	       }
	       }
	       
	       /**
	        * 
	        */
	       @Test
	   	public void testGetSingleCustPhoneNum() {
	    	   Response data = get("/Phonenumbers/Swathi");
    		   loggercntrl.debug("Status code of the response testGetSingleCustPhoneNum ::: " + data.getStatusCode()); 
    		   
    		   try {
    			   Assert.assertEquals(200, data.getStatusCode());
				JSONObject jResponse = new JSONObject(data.body().asString());
				 loggercntrl.debug("Response testGetSingleCustPhoneNum ::: " + jResponse);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   
	   	}

	       /**
	        * 
	        */
	   	@Test
	   	public void testEnablePhonenumber() {
	   	}
	 
}
