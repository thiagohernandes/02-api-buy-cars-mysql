package com.kubernetes.api.service;

import com.kubernetes.api.client.CarroClient;
import com.kubernetes.api.dto.CarroDto;
import com.kubernetes.api.dto.CompraDto;
import com.kubernetes.api.entity.CompraEntity;
import com.kubernetes.api.mapper.CompraMapper;
import com.kubernetes.api.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private CarroClient carroClient;

    public CompraDto saveCompra(CompraDto compraDto) {
        return CompraMapper.entityToDto(compraRepository.save(CompraEntity.builder()
                .idCarro(compraDto.getIdCarro())
                .valorTotal(compraDto.getValorTotal())
                .build()));
    }

    public CompraDto getCompraById(Long id) throws Exception {
        Optional<CompraEntity> compraEntity = Optional.of(compraRepository.findById(id).orElseThrow(Exception::new));
        return CompraMapper.entityToDto(compraEntity.get());
    }

    public CarroDto getCarroById(Long id) throws Exception {
        ResponseEntity<CarroDto> carroDto = carroClient.getCarroById(id);
        if(Objects.isNull(carroDto)){
            throw new Exception("Problemas na pesquisa do carro");
        }
        return carroDto.getBody();
    }
}
