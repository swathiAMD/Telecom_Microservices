package com.example.telecommicroservices.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.telecommicroservices.TelecomMicroservicesApplication;
import com.example.telecommicroservices.exception.TelecomMicroservicesException;
import com.example.telecommicroservices.pojo.Customer;
import com.example.telecommicroservices.pojo.PhoneDetails;

@RestController
public class TelecomController {
	
	/**
	 * 
	 */
	static Logger loggercntrl = LogManager.getLogger(TelecomController.class);
	
	/**
	 * 
	 */
	
	
	//private final static String ERROR_PATH = "/error";
	/**
	 * 
	 */
	
	static private HashSet<Customer> cust=new HashSet<Customer>();
	/**
	 * 
	 */
	
	static private HashSet<PhoneDetails> phonedetails1= new HashSet<PhoneDetails>();
	
	/**
	 * 
	 */
	
	static private HashSet<PhoneDetails> phonedetails2= new HashSet<PhoneDetails>();
	
	/**
	 * 
	 */
	static private List<PhoneDetails> newList=new ArrayList<PhoneDetails>();
	
	/**
	 * 
	 */
	static private String message="Phone number is not available";
	
	
	/**
	 * Loading the sample data here as the DataSource is not used in this project.
	 */
	
	static {
		
	 phonedetails1.add(new PhoneDetails("89099909", "+44", true));
	 phonedetails1.add(new PhoneDetails("123455", "+91", true));
	 phonedetails1.add(new PhoneDetails("234555", "+1", true));
	 phonedetails1.add(new PhoneDetails("555555", "+44", true));
	 phonedetails1.add(new PhoneDetails("5555555555", "+1", true));
	 phonedetails1.add(new PhoneDetails("77777777", "+44", true));
	 
	 phonedetails2.add(new PhoneDetails("3344455555", "+44", true));
	 phonedetails2.add(new PhoneDetails("9089573992", "+91", true));
	 phonedetails2.add(new PhoneDetails("23455555", "+44", true));
	 phonedetails2.add(new PhoneDetails("890983847729", "+44", false));
	 phonedetails2.add(new PhoneDetails("098877662", "+1", false));
	 phonedetails2.add(new PhoneDetails("10927333", "+44", false));
	 phonedetails2.add(new PhoneDetails("119087655222", "+91", false));
	 phonedetails2.add(new PhoneDetails("3456789", "+1", true));
	
	 cust.add(new Customer("Swathi", phonedetails1));
	 cust.add(new Customer("Santhosh", phonedetails2));
	
	 newList = Stream.of(phonedetails1, phonedetails2)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
	 
	 loggercntrl.debug("Dummy data has been loaded");
	}
	
	
	
/**
 * 
 * @return
 */
	
	@RequestMapping(value = { "/","/Phonenumbers" }, method = RequestMethod.GET)
	
	public List<PhoneDetails> getAllPhoneNumbers()
	{
	
		loggercntrl.debug("You have invoked '/' or '/Phonenumbers' API");
		return newList;
		
	}
	
/**
 * 	
 * @param fullName
 * @return
 */
	
@RequestMapping(value = { "/Phonenumbers/{fullName}" }, method = RequestMethod.GET)
	
	public Optional<Customer> getSingleCustPhoneNum(@PathVariable String fullName)
	{
	loggercntrl.debug("You have invoked '/Phonenumbers/{fullName}' API");
	Optional<Customer> foundcustomer= cust.stream()
			 .filter(customer -> 
			 		customer.getFullName().equalsIgnoreCase(fullName)).findFirst();
	if(foundcustomer.isPresent()) {	
	return foundcustomer;}
	else {
		loggercntrl.debug("Customer  "+fullName+" not found.");
		throw new TelecomMicroservicesException("Customer  "+fullName+" not found." );}
	}

/**
 * 
 * @param phoneno
 * @param enable
 * @return
 */


@RequestMapping(value = { "/Phonenumbers/{phoneno}/enable/{enable}" }, method = RequestMethod.GET)
@ResponseBody
public String enablePhonenumber(@PathVariable String phoneno ,@PathVariable Boolean enable )
{
	loggercntrl.debug("You have invoked '/Phonenumbers/{phoneno}/enable/{enable}' API");
newList.forEach(ph->{
		if (ph.getPhoneNumber().equalsIgnoreCase(phoneno))
				{
			message="Phone number found and changed the flag on the phone number to "+enable.toString();
			ph.setIsActive(enable);
				}
		else {
			loggercntrl.debug(phoneno +"  "+message);
			throw new TelecomMicroservicesException(phoneno +"  "+message);
		}
		
	});

return message;
}
/**
 * 
 * @return
 */

@RequestMapping(value= {"/error"}, method = RequestMethod.GET)
@ResponseBody
public String errormodeanalysis()
{
return "found error";
}

/**
 * 
 * @param ex
 * @return
 */
@ExceptionHandler(TelecomMicroservicesException.class)
public String handlingException(TelecomMicroservicesException ex)
{
	
	return ex.toString();
	
}
}
