package com.kubernetes.api.controller;

import com.kubernetes.api.dto.CarroDto;
import com.kubernetes.api.dto.CompraDto;
import com.kubernetes.api.service.CompraService;
import feign.Body;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compra")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @GetMapping("/{id}")
    public ResponseEntity<CompraDto> getCompraById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(compraService.getCompraById(id));
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<CarroDto> getClientCarroById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(compraService.getCarroById(id));
    }

    @PostMapping()
    public ResponseEntity<CompraDto> saveCompra(@RequestBody CompraDto compraDto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(compraService.saveCompra(compraDto));
    }
}
