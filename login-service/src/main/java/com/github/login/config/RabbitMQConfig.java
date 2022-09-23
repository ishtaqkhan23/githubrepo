package com.github.login.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class RabbitMQConfig {

	@Value("${github.rabbitmq.queue}")
	String queueName;

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	// create MessageListenerContainer using default connection factory
	@Bean
	MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory,
			RabbitMQListener rabbitMQListener) {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
		simpleMessageListenerContainer.setQueues(queue());
		simpleMessageListenerContainer.setMessageListener(rabbitMQListener);
		return simpleMessageListenerContainer;

	}

}