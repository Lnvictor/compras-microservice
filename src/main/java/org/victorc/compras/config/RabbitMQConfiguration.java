package org.victorc.compras.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfiguration {
    @Bean
    public Queue createQueue(){
        return QueueBuilder.durable("efetivacao_compra.notificacao").build();
    }


    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> listener(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public FanoutExchange createFanoutExchange(){
        return ExchangeBuilder.fanoutExchange("efetivacao_compra.ex").build();
    }

    @Bean
    public Binding createBinding(){
        return BindingBuilder.bind(createQueue()).to(createFanoutExchange());
    }

    @Bean
    public MessageConverter createJsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rt = new RabbitTemplate();
        rt.setConnectionFactory(connectionFactory);
        rt.setMessageConverter(createJsonMessageConverter());

        return rt;
    }
}
