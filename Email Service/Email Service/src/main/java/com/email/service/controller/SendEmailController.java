package com.email.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.service.service.ReadEmailAddressService;

@RestController
public class SendEmailController 
{
	@Autowired
	private ReadEmailAddressService emailService;
	
	private static final Logger Log = LoggerFactory.getLogger(SendEmailController.class);
	
	@GetMapping("/sendEmail")
	public int sendEmail()
	{
		Log.debug("Request received in controller to read list of emails from excel sheet and send email to them");
		return emailService.readExcelSheet();
	}
}
