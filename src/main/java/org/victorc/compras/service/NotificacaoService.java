package org.victorc.compras.service;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.victorc.compras.dto.CompraDTO;

@Service
@AllArgsConstructor
public class NotificacaoService {
    private RabbitTemplate rabbitTemplate;

    public void notificar(CompraDTO dto, String exchange) {
        this.rabbitTemplate.convertAndSend(exchange, "", dto);
    }
}
