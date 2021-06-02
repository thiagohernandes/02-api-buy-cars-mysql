package com.kubernetes.api.mapper;

import com.kubernetes.api.dto.CompraDto;
import com.kubernetes.api.entity.CompraEntity;

public class CompraMapper {

    public static CompraDto entityToDto(CompraEntity compraEntity) {
        return CompraDto.builder()
                .id(compraEntity.getId())
                .idCarro(compraEntity.getIdCarro())
                .valorTotal(compraEntity.getValorTotal())
                .build();
    }
}
