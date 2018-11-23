package com.lyc.rabbitmq.conf;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "spring.rabbitmq.isOpen", havingValue = "true")
public class RabbitExchangeConfig {

    @Autowired
    private RabbitAdmin rabbitAdmin;
    @Value("${spring.rabbitmq.queueName}")
    private String queueName;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    public RabbitExchangeConfig() {
    }

    @Bean
    Queue fanoutQueue() {
        Queue queue = new Queue(queueName, true);
        this.rabbitAdmin.declareQueue(queue);
        return queue;
    }

    @Bean
    FanoutExchange fanoutExchange() {
        FanoutExchange fanoutExchange = new FanoutExchange(exchange);
        this.rabbitAdmin.declareExchange(fanoutExchange);
        return fanoutExchange;
    }

    @Bean
    public Binding fanoutBinding() {
        return BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());
    }
}