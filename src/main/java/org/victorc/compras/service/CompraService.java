package org.victorc.compras.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.victorc.compras.dto.CompraDTO;
import org.victorc.compras.entity.Compra;
import org.victorc.compras.mapper.CompraMapper;
import org.victorc.compras.repository.CompraRepository;

@Service
@AllArgsConstructor
public class CompraService {
    private CompraRepository compraRepository;
    private NotificacaoService notificacaoService;

    public CompraDTO salvar(CompraDTO compra) {
        Compra compraEntity = CompraMapper.INSTANCE.convertDtoToEntity(compra);
        CompraDTO dto = CompraMapper.INSTANCE.convertEntityToDto(compraRepository.save(compraEntity));
        notificacaoService.notificar(dto, "efetivacao_compra.ex");

        return dto;
    }
}
