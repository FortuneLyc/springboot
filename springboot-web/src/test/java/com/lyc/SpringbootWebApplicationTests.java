package com.lyc;

import com.lyc.rabbitmq.mq.AmqpServiceProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootWebApplicationTests {

    @Autowired
    private AmqpServiceProducer amqpServiceProducer;
    @Test
    public void contextLoads() {
    }

    @Test
    public void sender(){
        amqpServiceProducer.convertAndSend("test");
    }

}
