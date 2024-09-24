package org.victorc.compras.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.victorc.compras.dto.CompraDTO;
import org.victorc.compras.entity.Compra;
import org.victorc.compras.repository.CompraRepository;

@Service
@AllArgsConstructor
public class CompraService {
    private CompraRepository compraRepository;

    public Compra salvar(CompraDTO compra) {
        Compra compraEntity = Compra.fromDTO(compra);
        return compraRepository.save(compraEntity);
    }
}
