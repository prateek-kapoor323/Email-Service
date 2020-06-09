package com.email.service.common;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailUtility implements EmailService
{

	@Autowired
	public JavaMailSender emailSender;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtility.class);

	/**
	 * @author Prateek Kapoor
	 * Method to send emails to the user
	 * @param emailAddress
	 * @param title
	 * @param body
	 * @param from
	 * @return 1 in case of success; else null in case of exception
	 * @since 11-05-2020
	 */
	@Override
	public int send(List<String> emailAddress,String title,String body,String from)
	{
		LOGGER.debug("Request received in utility method to send email to the user");
        MimeMessage mail = emailSender.createMimeMessage();
        try
        {
        	LOGGER.debug("In try block to send email to user with email {} ",emailAddress);
			MimeMessageHelper helper = new MimeMessageHelper(mail, true,"utf-8");
			for(String s : emailAddress)
			{

				helper.setFrom(from);
				helper.setTo(s);
	            helper.setSubject(title);
	            mail.setContent(body,"text/html");
	            emailSender.send(mail);
	            LOGGER.debug("Email successfully sent to user");
			}
            return 1;
		}
        catch (MessagingException e) 
        {
        	LOGGER.error("An exception occurred while sending the email, Email could not be sent "+e);
        	return -25;
		}
        
	}
}
