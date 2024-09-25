package org.victorc.compras.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.victorc.compras.dto.CompraDTO;
import org.victorc.compras.entity.Compra;
import org.victorc.compras.service.CompraService;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/compras")
public class CompraController {
    private CompraService compraService;

    @GetMapping
    public ResponseEntity sayHello(){
        Map<String, String> map = Map.of("message", "Hello World");

        return ResponseEntity.ok(map);
    }

    @PostMapping
    public ResponseEntity<CompraDTO> sayHelloPost(@RequestBody CompraDTO dto){
        return ResponseEntity.ok(compraService.salvar(dto));
    }
}
