package org.victorc.compras.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.victorc.compras.dto.CompraDTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigo;
    private String descricao;
    private Double valor;
    private String emailComprador;

    public static Compra fromDTO(CompraDTO dto) {
        Compra compra = new Compra();
        compra.setCodigo("123");
        compra.setDescricao(dto.descricao());
        compra.setValor(dto.valor());
        compra.setEmailComprador(dto.email());
        return compra;
    }
}
