package com.lyc.rabbitmq.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Component
@ConditionalOnProperty(name = "spring.rabbitmq.isOpen", havingValue = "true")
public class AmqpServiceConsumer {
	private Logger logger = LoggerFactory.getLogger(AmqpServiceConsumer.class);


	public AmqpServiceConsumer() {
	}

	@RabbitListener(queues = {"${spring.rabbitmq.queueName}"})
	public void receiveSmsCodeQueue(String message) {
		this.logger.info("------处理注册解析日志消息------");
		this.logger.debug(message);
		System.out.println(message);
	}
}
