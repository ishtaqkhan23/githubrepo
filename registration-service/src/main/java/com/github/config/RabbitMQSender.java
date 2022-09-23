package com.github.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.github.model.User;
@RefreshScope
@Service
public class RabbitMQSender {
	private static Logger log = LoggerFactory.getLogger(RabbitMQSender.class);
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${github.rabbitmq.exchange}")
	private String exchange;

	@Value("${github.rabbitmq.routingkey}")
	private String routingkey;

	public void send(User user) {
		amqpTemplate.convertAndSend(exchange, routingkey, user);
		if (log.isInfoEnabled())
			log.info(String.format("Send msg = %s", user));

	}
}