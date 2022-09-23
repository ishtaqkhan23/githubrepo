package com.github.login.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.login.model.RegistrationDetails;
import com.github.login.service.RegistrationService;


@Service
public class RabbitMQListener implements MessageListener {
	
	private static Logger log = LoggerFactory.getLogger(RabbitMQListener.class);
	
	@Autowired
	RegistrationService registrationService;

	public void onMessage(Message message) {
		if(log.isInfoEnabled())
	    	log.info(String.format("Consuming Message - %s" , new String(message.getBody())));
		ObjectMapper obj = new ObjectMapper();
		RegistrationDetails rd;
		try {
			rd = obj.readValue(new String(message.getBody()), RegistrationDetails.class);
			registrationService.saveDetails(rd);
		} catch (IOException e) {
			log.error("exception",e);
		}
	}
}
