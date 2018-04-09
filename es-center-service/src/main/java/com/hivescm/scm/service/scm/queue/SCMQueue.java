package com.hivescm.scm.service.scm.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:
 * @Description: SCM队列
 * @Date: 2018/4/9 14:35
 */
@Configuration
public class SCMQueue {
    @Bean
    DirectExchange scmDirectExchange()
    {
        return new DirectExchange("exchange.scm.mq");
    }
    @Bean
    Queue queueSCM() {
        return new Queue("queue-scm-mq");
    }
    @Bean
    Binding bindingDirectExchangeSCM(Queue queueSCM, DirectExchange scmDirectExchange) {
        return BindingBuilder.bind(queueSCM).to(scmDirectExchange).with("queue-scm-mq");
    }
}
