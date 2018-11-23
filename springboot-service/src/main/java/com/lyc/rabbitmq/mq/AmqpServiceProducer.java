package com.lyc.rabbitmq.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: lyc
 * @Date: 2018/11/22 16:44
 * @Description: ${DESCRIPTION}
 */
@Component
public class AmqpServiceProducer {

    @Value("${spring.rabbitmq.queueName}")
    private String queueName;

    @Autowired
    private  AmqpTemplate amqpTemplate;

    public  void convertAndSend(String message) {
		amqpTemplate.convertAndSend(queueName, message);
    }
}
